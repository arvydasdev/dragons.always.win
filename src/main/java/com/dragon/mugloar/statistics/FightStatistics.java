package com.dragon.mugloar.statistics;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.FightStatus;
import com.dragon.mugloar.client.dto.Knight;
import com.dragon.mugloar.client.dto.WeatherReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gusciarv
 */
@Getter
@Setter
@AllArgsConstructor
public class FightStatistics {

    private FightStatus fightStatus;
    private WeatherReport weatherReport;
    private Knight knight;
    private Dragon dragon;
}
