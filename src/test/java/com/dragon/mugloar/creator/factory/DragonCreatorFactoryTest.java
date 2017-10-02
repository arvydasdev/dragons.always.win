package com.dragon.mugloar.creator.factory;

import com.dragon.mugloar.client.dto.WeatherReport;
import com.dragon.mugloar.creator.impl.NormalDragonCreator;
import com.dragon.mugloar.creator.impl.SharpestClawsDragonCreator;
import com.dragon.mugloar.creator.impl.ZenDragonCreator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

/**
 * @author gusciarv
 */
public class DragonCreatorFactoryTest {

    @InjectMocks
    private DragonCreatorFactory dragonCreatorFactory;

    @Mock
    private NormalDragonCreator normalDragonCreator;
    @Mock
    private SharpestClawsDragonCreator sharpestClawsDragonCreator;
    @Mock
    private ZenDragonCreator zenDragonCreator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionWhenWeatherCodeNotRecognized() {
        WeatherReport report = new WeatherReport();
        report.setCode("SRO");
        dragonCreatorFactory.getDragonCreator(report);
    }
}
