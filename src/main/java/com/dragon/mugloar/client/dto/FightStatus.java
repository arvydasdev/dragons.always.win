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
public class FightStatus implements Serializable {

    private String status;
    private String message;
}
