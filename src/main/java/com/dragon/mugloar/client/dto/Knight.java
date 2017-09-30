package com.dragon.mugloar.client.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author gusciarv
 */
@Getter
@Setter
@ToString
public class Knight implements Serializable {

    private String name;
    private int attack;
    private int armor;
    private int agility;
    private int endurance;
}
