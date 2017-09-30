package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author gusciarv
 */
public class NormalDragonCreatorTest {

    private NormalDragonCreator normalDragonCreator;

    @Before
    public void setUp() {
        normalDragonCreator = new NormalDragonCreator();
    }

    @Test
    public void testThatCorrectDragonIsCreated() {
        Knight knight = createKnight(5, 7, 5, 3);
        Dragon dragon = normalDragonCreator.createDragon(knight);
        assertEquals(dragon.getScaleThickness(), 4);
        assertEquals(dragon.getClawSharpness(), 9);
        assertEquals(dragon.getWingStrength(), 4);
        assertEquals(dragon.getFireBreath(), 3);

        knight = createKnight(7, 5, 8, 0);
        dragon = normalDragonCreator.createDragon(knight);
        assertEquals(dragon.getScaleThickness(), 6);
        assertEquals(dragon.getClawSharpness(), 4);
        assertEquals(dragon.getWingStrength(), 10);
        assertEquals(dragon.getFireBreath(), 0);
    }

    private Knight createKnight(int attack, int armor, int agility, int endurance) {
        Knight knight = new Knight();
        knight.setAttack(attack);
        knight.setArmor(armor);
        knight.setAgility(agility);
        knight.setEndurance(endurance);
        return knight;
    }
}
