package com.dragon.mugloar.app;

import com.dragon.mugloar.client.GameApiClient;
import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.FightStatus;
import com.dragon.mugloar.client.dto.Game;
import com.dragon.mugloar.client.dto.WeatherReport;
import com.dragon.mugloar.creator.factory.DragonCreatorFactory;
import com.dragon.mugloar.statistics.FightStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Cycles through the fights give number of times and returns results
 * @author gusciarv
 */
@Component
public class GameSimulator {

    private static final Logger LOG = LoggerFactory.getLogger(GameSimulator.class);

    private final DragonCreatorFactory dragonCreatorFactory;
    private final GameApiClient gameApiClient;

    public GameSimulator(DragonCreatorFactory dragonCreatorFactory, GameApiClient gameApiClient) {
        this.dragonCreatorFactory = dragonCreatorFactory;
        this.gameApiClient = gameApiClient;
    }

    /**
     * Simulates number of fights provided by parameter
     * @param fights - number of fights to fight
     * @return list containing fight results
     */
    public List<FightStatistics> startFights(int fights) {
        LOG.info(MessageFormat.format("Program will execute {0} fights", fights));

        List<FightStatistics> result = new ArrayList<>();
        int fightCounter = 1;
        while(fightCounter <= fights) {
            try {
                LOG.info(MessageFormat.format("Generating game {0} ...", fightCounter));
                //getting game
                Game game = gameApiClient.getGame();
                String gameId = game.getGameId();

                //getting weather
                WeatherReport weatherReport = gameApiClient.getWeather(gameId);
                if ("SRO".equals(weatherReport.getCode())) {
                    LOG.info(MessageFormat.format("Generating game {0} failed because of storm", fightCounter));
                    //lets not fight in storm cause we will die
                    continue;
                }

                Dragon dragon = dragonCreatorFactory.getDragonCreator(weatherReport).createDragon(game.getKnight());
                //getting fight result
                FightStatus status = gameApiClient.putSolution(gameId, dragon);
                result.add(new FightStatistics(status, weatherReport, game.getKnight(), dragon));
            }
            catch (Exception e) {
                LOG.error(MessageFormat.format("Error occurred while simulating game {0}. Will try to continue.. ", fightCounter), e);
            }
            fightCounter++;
        }
        return result;
    }

}
