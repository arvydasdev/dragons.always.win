package com.dragon.mugloar.creator.impl;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.Knight;
import com.dragon.mugloar.creator.DragonCreator;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates dragon according to knights skills
 * @author gusciarv
 */
@Component
public class NormalDragonCreator implements DragonCreator {

    private static final Logger LOG = LoggerFactory.getLogger(NormalDragonCreator.class);

    public Dragon createDragon(Knight knight) {
        List<Pair<String,Integer>> skills = new ArrayList<>();
        skills.add(new Pair<>("ATTACK", knight.getAttack()));
        skills.add(new Pair<>("ARMOR", knight.getArmor()));
        skills.add(new Pair<>("AGILITY", knight.getAgility()));
        skills.add(new Pair<>("ENDURANCE", knight.getEndurance()));

        skills.sort((Pair<String,Integer> one, Pair<String, Integer> two) -> Integer.compare(two.getValue1(), one.getValue1()));

        Dragon dragon = new Dragon();
        for (Pair<String,Integer> skill : skills) {
            int dragonSkill = getDragonSkill(skills.indexOf(skill), skill.getValue1());
            switch (skill.getValue0()) {
                case "ATTACK":
                    dragon.setScaleThickness(dragonSkill);
                    break;
                case "ARMOR":
                    dragon.setClawSharpness(dragonSkill);
                    break;
                case "AGILITY":
                    dragon.setWingStrength(dragonSkill);
                    break;
                case "ENDURANCE":
                    dragon.setFireBreath(dragonSkill);
                    break;
            }
        }
        LOG.debug("Dragon to fight in normal weather created " + dragon);
        return dragon;
    }

    private int getDragonSkill(int sortIndex, int knightSkill) {
            switch (sortIndex) {
                case 0:
                    return knightSkill + 2;
                case 1:
                    return knightSkill - 1;
                case 2:
                    return knightSkill - 1;
                case 3:
                    return knightSkill;
                default:
                    return 0;
            }
    }

}
