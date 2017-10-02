package com.dragon.mugloar.statistics;

import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModelBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Generates fights statistics to spring shell ascii table
 *
 * @author gusciarv
 */
@Component
public class StatisticsGenerator {

    /**
     * Converts fight result list into spring shell ascii table
     *
     * @param fightStatistics - list of fight results
     * @return table presenting fight results
     */
    public Table presentTable(List<FightStatistics> fightStatistics) {
        TableModelBuilder<String> tableModelBuilder = new TableModelBuilder<>();
        buildRow(tableModelBuilder, "Fight id", "Status", "Weather", "Knight skills", "Dragon skills");

        for (FightStatistics fight : fightStatistics) {
            buildRow(tableModelBuilder, fightStatistics.indexOf(fight) + 1, fight.getFightStatus().getStatus(),
                    fight.getWeatherReport().getCode(), fight.getKnight(), fight.getDragon());
        }

        TableBuilder tableBuilder = new TableBuilder(tableModelBuilder.build());
        tableBuilder.addFullBorder(BorderStyle.fancy_heavy_triple_dash);
        return tableBuilder.build();
    }

    private void buildRow(TableModelBuilder<String> tableModelBuilder, Object... rowValue) {
        tableModelBuilder.addRow();
        for (Object value : rowValue) {
            tableModelBuilder.addValue(value != null ? value.toString() : null);
        }
    }

}
