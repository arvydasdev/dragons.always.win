package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.creator.DragonCreator;
import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Creates dragon with sharpest claws. Claws are better than fire.
 * @author gusciarv
 */
@Component
public class SharpestClawsDragonCreator implements DragonCreator {

    private static final Logger LOG = LoggerFactory.getLogger(SharpestClawsDragonCreator.class);

    public Dragon createDragon(Knight knight) {
        Dragon dragon = new Dragon();
        dragon.setClawSharpness(10);
        dragon.setFireBreath(0);
        dragon.setWingStrength(5);
        dragon.setScaleThickness(5);

        LOG.debug("Dragon to fight during flood created " + dragon);
        return dragon;
    }

}
