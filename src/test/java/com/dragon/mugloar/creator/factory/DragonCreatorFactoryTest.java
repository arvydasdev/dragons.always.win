package com.dragon.mugloar.creator.factory;

import com.dragon.mugloar.client.dto.WeatherReport;
import com.dragon.mugloar.creator.impl.NormalDragonCreator;
import com.dragon.mugloar.creator.impl.SharpestClawsDragonCreator;
import com.dragon.mugloar.creator.impl.StormDragonCreator;
import com.dragon.mugloar.creator.impl.ZenDragonCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author gusciarv
 */
public class DragonCreatorFactoryTest {

    private DragonCreatorFactory dragonCreatorFactory;

    private NormalDragonCreator normalDragonCreator;
    private SharpestClawsDragonCreator sharpestClawsDragonCreator;
    private ZenDragonCreator zenDragonCreator;
    private StormDragonCreator stormDragonCreator;

    @Before
    public void setUp() {
        normalDragonCreator = new NormalDragonCreator();
        sharpestClawsDragonCreator = new SharpestClawsDragonCreator();
        zenDragonCreator = new ZenDragonCreator();
        stormDragonCreator = new StormDragonCreator();
        dragonCreatorFactory = new DragonCreatorFactory(normalDragonCreator, sharpestClawsDragonCreator, zenDragonCreator, stormDragonCreator);
    }

    @Test
    public void testCorrectFactoryCreated() {
        WeatherReport report = new WeatherReport();
        report.setCode("NMR");
        assertEquals(dragonCreatorFactory.getDragonCreator(report), normalDragonCreator);
        report.setCode("HVA");
        assertEquals(dragonCreatorFactory.getDragonCreator(report), sharpestClawsDragonCreator);
        report.setCode("T E");
        assertEquals(dragonCreatorFactory.getDragonCreator(report), zenDragonCreator);
        report.setCode("SRO");
        assertEquals(dragonCreatorFactory.getDragonCreator(report), stormDragonCreator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionWhenWeatherCodeNotRecognized() {
        WeatherReport report = new WeatherReport();
        report.setCode("UNKNOWN");
        dragonCreatorFactory.getDragonCreator(report);
    }
}
