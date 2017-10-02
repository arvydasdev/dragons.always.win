package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.creator.DragonCreator;
import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Creates real zen dragon. All the skills are equally the same.
 * @author gusciarv
 */
@Component
public class ZenDragonCreator implements DragonCreator {

    private static final Logger LOG = LoggerFactory.getLogger(ZenDragonCreator.class);

    public boolean appliedForWeather(String weatherCode) {
        return "FUNDEFINEDG".equals(weatherCode) || "T E".equals(weatherCode);
    }

    public Dragon createDragon(Knight knight) {
        Dragon dragon = new Dragon();
        dragon.setScaleThickness(5);
        dragon.setWingStrength(5);
        dragon.setFireBreath(5);
        dragon.setClawSharpness(5);

        LOG.debug("Dragon to fight in long dry weather created " + dragon);
        return dragon;
    }
}
