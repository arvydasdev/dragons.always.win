package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author gusciarv
 */
public class SharpestClawsDragonCreatorTest {

    private SharpestClawsDragonCreator sharpestClawsDragonCreator;

    @Before
    public void setUp() {
        sharpestClawsDragonCreator = new SharpestClawsDragonCreator();
    }

    @Test
    public void testThatCorrectDragonIsCreated() {
        Dragon dragon = sharpestClawsDragonCreator.createDragon(new Knight());
        assertEquals(dragon.getScaleThickness(), 5);
        assertEquals(dragon.getClawSharpness(), 10);
        assertEquals(dragon.getWingStrength(), 5);
        assertEquals(dragon.getFireBreath(), 0);
    }

}
