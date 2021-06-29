package pl.pp.simulation.model;

import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panel.ControlPanel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class Foxes {

    public static List<Fox> foxList = new LinkedList<>();
    public static List<Fox> newFoxList = new LinkedList<>();
    public static List<Fox> deathFoxList = new LinkedList<>();

    public static void move() {
        Foxes.newFoxList.clear();
        Foxes.deathFoxList.clear();
        for (Fox fox : Foxes.foxList) {
            fox.move();
        }
        Foxes.foxList.addAll(Foxes.newFoxList);
        Foxes.foxList.removeAll(Foxes.deathFoxList);
    }

    public static void updateAmount() {
        int foxAmount = Foxes.foxList.size();
        ControlPanel.foxParameter.setValue(foxAmount);
        SimulationChart.simulationChart.getFoxSeries().add(steps, foxAmount);
    }

    public static void draw(Graphics2D graphics2D) {
        for (Fox grass : Foxes.foxList) {
            grass.draw(graphics2D);
        }
    }
}
