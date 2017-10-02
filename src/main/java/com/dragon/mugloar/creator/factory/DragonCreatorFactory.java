package com.dragon.mugloar.creator.factory;

import com.dragon.mugloar.client.dto.WeatherReport;
import com.dragon.mugloar.creator.DragonCreator;
import com.dragon.mugloar.creator.impl.NormalDragonCreator;
import com.dragon.mugloar.creator.impl.SharpestClawsDragonCreator;
import com.dragon.mugloar.creator.impl.ZenDragonCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Factory for building dragon creators
 * @author gusciarv
 */
@Component
public class DragonCreatorFactory {

    private static final Logger LOG = LoggerFactory.getLogger(DragonCreatorFactory.class);

    private final NormalDragonCreator normalDragonCreator;
    private final SharpestClawsDragonCreator sharpestClawsDragonCreator;
    private final ZenDragonCreator zenDragonCreator;

    public DragonCreatorFactory(NormalDragonCreator normalDragonCreator, SharpestClawsDragonCreator sharpestClawsDragonCreator, ZenDragonCreator zenDragonCreator) {
        this.normalDragonCreator = normalDragonCreator;
        this.sharpestClawsDragonCreator = sharpestClawsDragonCreator;
        this.zenDragonCreator = zenDragonCreator;
    }

    /**
     * Creates instances of {@link DragonCreator} according to weather
     * @param weatherReport - weather report from game api
     * @return {@link DragonCreator}
     */
    public DragonCreator getDragonCreator(WeatherReport weatherReport) {
        String weather = weatherReport.getCode();
        switch (weather) {
            //normal weather
            case "NMR" : {
                return normalDragonCreator;
            }
            //floods
            case "HVA" : {
                return sharpestClawsDragonCreator;
            }
            //long dry, fog
            case "FUNDEFINEDG" :
            case "T E" : {
                return zenDragonCreator;
            }
            default : {
                String message = MessageFormat.format("weather code {0} not recognised", weather);
                LOG.error(message);
                throw new IllegalArgumentException(message);
            }
        }
    }
}
