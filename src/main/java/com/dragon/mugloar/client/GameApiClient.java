package com.dragon.mugloar.client;

import com.dragon.mugloar.client.dto.Game;
import com.dragon.mugloar.client.dto.WeatherReport;
import com.dragon.mugloar.client.dto.FightStatus;
import com.dragon.mugloar.client.dto.Dragon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.MessageFormat;

/**
 * Calls http://www.dragonsofmugloar.com to get game, weather and solve the battle
 *
 * @author gusciarv
 */
@Component
public class GameApiClient {

    private static final Logger LOG = LoggerFactory.getLogger(GameApiClient.class);

    private static final String MUGLOAR_PATH = "http://www.dragonsofmugloar.com";

    /**
     * Gets game from game api
     *
     * @return game containing game id
     */
    public Game getGame() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(MUGLOAR_PATH);
        Invocation.Builder invocationBuilder = webTarget.path("api/game").request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get(Response.class);
        Game game = ResponseHandler.handleResponse(response, Game.class);
        LOG.debug(MessageFormat.format("Game dto from server {0}", game));
        return game;
    }

    /**
     * Fetches weather report from game id using game id
     *
     * @param gameId - id of the current game
     * @return weather report
     */
    public WeatherReport getWeather(String gameId) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(MUGLOAR_PATH);
        Invocation.Builder invocationBuilder = webTarget.path("weather/api/report/").path(gameId).request(MediaType.APPLICATION_XML);

        Response response = invocationBuilder.get(Response.class);
        WeatherReport weatherReport = ResponseHandler.handleResponse(response, WeatherReport.class);
        LOG.debug(MessageFormat.format("Weather dto from server {0} ", weatherReport));
        return weatherReport;
    }

    /**
     * Puts dragon to fight against knight for current game id
     *
     * @param gameId - id of current game
     * @param dragon - generated dragon to fight against knight
     * @return fight result telling if fight was successful or not
     */
    public FightStatus putSolution(String gameId, Dragon dragon) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        String input = objectMapper.writeValueAsString(dragon);

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(MUGLOAR_PATH);
        Invocation.Builder invocationBuilder = webTarget.path("api/game").path(gameId).path("solution").request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.put(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
        FightStatus fightStatus = ResponseHandler.handleResponse(response, FightStatus.class);
        LOG.debug(MessageFormat.format("Fight report from server {0}", fightStatus));
        return fightStatus;
    }
}
