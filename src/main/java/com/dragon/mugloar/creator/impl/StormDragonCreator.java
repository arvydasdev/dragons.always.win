package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import com.dragon.mugloar.creator.DragonCreator;
import org.springframework.stereotype.Component;

/**
 * Creates no dragon to fight in storm.
 * @author gusciarv
 */
@Component
public class StormDragonCreator implements DragonCreator {

    public boolean appliedForWeather(String weatherCode) {
        return "SRO".equals(weatherCode);
    }

    public Dragon createDragon(Knight knight) {
        return null;
    }
}
