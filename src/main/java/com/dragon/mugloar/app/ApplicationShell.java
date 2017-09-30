package com.dragon.mugloar.app;

import com.dragon.mugloar.statistics.FightStatistics;
import com.dragon.mugloar.statistics.StatisticsGenerator;
import org.hibernate.validator.constraints.Range;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.Table;

import java.util.List;

/**
 * Spring shell for executing command line
 * @author gusciarv
 */
@ShellComponent
public class ApplicationShell {

    private final StatisticsGenerator statisticsGenerator;
    private final GameSimulator gameSimulator;

    public ApplicationShell(StatisticsGenerator statisticsGenerator, GameSimulator gameSimulator) {
        this.statisticsGenerator = statisticsGenerator;
        this.gameSimulator = gameSimulator;
    }

    @ShellMethod("Starts number of fights provided by parameter. Default - 10 fights")
    public Table startFight(@ShellOption(defaultValue = "10") @Range(min = 1) Integer fights) {
        List<FightStatistics> fightStatus = gameSimulator.startFights(fights);
        return statisticsGenerator.presentTable(fightStatus);
    }
}
