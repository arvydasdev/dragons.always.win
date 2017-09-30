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
public class Game implements Serializable {

    private String gameId;
    private Knight knight;
}
