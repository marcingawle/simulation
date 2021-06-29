package pl.pp.simulation.model;

import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panel.ControlPanel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class GrassUtils {

    public static List<Grass> grassList = new LinkedList<>();
    private static int frequency = 2;

    public static void updateAmount() {
        int grassAmount = grassList.size();
        ControlPanel.grassParameter.setValue(grassAmount);
        SimulationChart.simulationChart.getGrassSeries().add(steps, grassAmount);
    }

    public static void draw(Graphics2D graphics2D) {
        for (Grass grass : grassList) {
            grass.draw(graphics2D);
        }
    }

    public static void grow() {
        if (steps % frequency == 0) {
            grassList.add(new Grass());
        }

    }
}

