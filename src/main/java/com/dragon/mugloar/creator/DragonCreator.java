package com.dragon.mugloar.creator;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import com.dragon.mugloar.creator.factory.DragonCreatorFactory;

/**
 * Dragon creator interface, actual implementations should make dragons according to knights stats.
 * Add implementation class to {@link DragonCreatorFactory}
 * @author gusciarv
 */
public interface DragonCreator {

    /**
     * Creates a dragon according to knight parameter
     * @param knight - knight instance from game api
     * @return dragon to fight a knight
     */
    Dragon createDragon(Knight knight);
}
