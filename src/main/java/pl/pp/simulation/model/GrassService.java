package pl.pp.simulation.model;

import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.utils.ParameterModel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class GrassService {

    private final List<Grass> grassList = new LinkedList<>();
    private final int frequency = 2;
    private SimulationChart simulationChart;
    private ParameterModel grassParameter;

    public List<Grass> getGrassList() {
        return grassList;
    }

    public void updateAmount() {
        int grassAmount = getGrassList().size();
        grassParameter.setValue(grassAmount);
        simulationChart.getGrassSeries().add(steps, grassAmount);
    }

    public void draw(Graphics2D graphics2D) {
        for (Grass grass : getGrassList()) {
            grass.draw(graphics2D);
        }
    }

    public void grow() {
        if (steps % frequency == 0) {
            getGrassList().add(new Grass());
        }
    }

    public void setSimulationChart(SimulationChart simulationChart) {
        this.simulationChart = simulationChart;
    }

    public void setGrassParameter(ParameterModel grassParameter) {
        this.grassParameter = grassParameter;
    }
}

