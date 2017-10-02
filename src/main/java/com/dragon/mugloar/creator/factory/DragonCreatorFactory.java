package com.dragon.mugloar.creator.factory;

import com.dragon.mugloar.client.dto.WeatherReport;
import com.dragon.mugloar.creator.DragonCreator;
import com.dragon.mugloar.creator.impl.NormalDragonCreator;
import com.dragon.mugloar.creator.impl.SharpestClawsDragonCreator;
import com.dragon.mugloar.creator.impl.StormDragonCreator;
import com.dragon.mugloar.creator.impl.ZenDragonCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Factory for building dragon creators
 * @author gusciarv
 */
@Component
public class DragonCreatorFactory {

    private static final Logger LOG = LoggerFactory.getLogger(DragonCreatorFactory.class);

    private final List<DragonCreator> dragonCreatorList;

    public DragonCreatorFactory(NormalDragonCreator normalDragonCreator, SharpestClawsDragonCreator sharpestClawsDragonCreator, ZenDragonCreator zenDragonCreator, StormDragonCreator stormDragonCreator) {
        dragonCreatorList = Arrays.asList(normalDragonCreator, sharpestClawsDragonCreator, zenDragonCreator, stormDragonCreator);
    }

    /**
     * Creates instances of {@link DragonCreator} according to weather
     * @param weatherReport - weather report from game api
     * @return {@link DragonCreator}
     */
    public DragonCreator getDragonCreator(WeatherReport weatherReport) {
        String weather = weatherReport.getCode();
        for (DragonCreator dragonCreator : dragonCreatorList) {
            if (dragonCreator.appliedForWeather(weather)) {
                return dragonCreator;
            }
        }
        String message = MessageFormat.format("weather code {0} not recognised", weather);
        LOG.error(message);
        throw new IllegalArgumentException(message);
    }
}
