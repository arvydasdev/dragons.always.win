package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * @author gusciarv
 */
public class StormDragonCreatorTest {

    private StormDragonCreator stormDragonCreator;

    @Before
    public void setUp() {
        stormDragonCreator = new StormDragonCreator();
    }

    @Test
    public void testThatCorrectDragonIsCreated() {
        Dragon dragon = stormDragonCreator.createDragon(new Knight());
        assertNull(dragon);
    }
}
