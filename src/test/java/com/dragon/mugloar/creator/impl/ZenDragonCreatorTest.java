package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author gusciarv
 */
public class ZenDragonCreatorTest {

    private ZenDragonCreator zenDragonCreator;

    @Before
    public void setUp() {
        zenDragonCreator = new ZenDragonCreator();
    }

    @Test
    public void testThatCorrectDragonIsCreated() {
        Dragon dragon = zenDragonCreator.createDragon(new Knight());
        assertEquals(dragon.getScaleThickness(), 5);
        assertEquals(dragon.getClawSharpness(), 5);
        assertEquals(dragon.getWingStrength(), 5);
        assertEquals(dragon.getFireBreath(), 5);
    }


}
