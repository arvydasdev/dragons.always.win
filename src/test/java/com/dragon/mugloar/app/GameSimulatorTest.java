package com.dragon.mugloar.app;

import com.dragon.mugloar.client.GameApiClient;
import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Game;
import com.dragon.mugloar.client.dto.Knight;
import com.dragon.mugloar.client.dto.WeatherReport;
import com.dragon.mugloar.creator.factory.DragonCreatorFactory;
import com.dragon.mugloar.creator.impl.NormalDragonCreator;
import com.dragon.mugloar.statistics.FightStatistics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author gusciarv
 */
public class GameSimulatorTest {

    @InjectMocks
    private GameSimulator gameSimulator;
    @Mock
    private DragonCreatorFactory dragonCreatorFactory;
    @Mock
    private GameApiClient gameApiClient;
    @Mock
    private NormalDragonCreator normalDragonCreator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testResultSize() {
        Game game = new Game();
        game.setGameId("12345678");
        game.setKnight(new Knight());

        WeatherReport weatherReport = new WeatherReport();
        when(gameApiClient.getGame()).thenReturn(game);
        when(gameApiClient.getWeather(game.getGameId())).thenReturn(weatherReport);
        when(dragonCreatorFactory.getDragonCreator(weatherReport)).thenReturn(normalDragonCreator);
        when(normalDragonCreator.createDragon(game.getKnight())).thenReturn(new Dragon());

        int size = 15;
        List<FightStatistics> fightStatistics = gameSimulator.startFights(size);
        assertTrue(fightStatistics.size() == size);
    }
}
