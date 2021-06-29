package pl.pp.simulation.model;

import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panel.ControlPanel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class Hares {

    public static List<Hare> hareList = new LinkedList<>();
    public static List<Hare> newHareList = new LinkedList<>();
    public static List<Hare> deathHareList = new LinkedList<>();

    public static void move() {
        newHareList.clear();
        deathHareList.clear();
        for (Hare hare : hareList) {
            hare.move();
        }

        hareList.addAll(newHareList);
        hareList.removeAll(deathHareList);
    }

    public static void updateAmount() {
        int hareAmount = hareList.size();
        ControlPanel.hareParameter.setValue(hareAmount);
        SimulationChart.simulationChart.getHareSeries().add(steps, hareAmount);
    }

    public static void draw(Graphics2D graphics2D) {
        for (Hare hare : Hares.hareList) {
            hare.draw(graphics2D);
        }
    }
}
