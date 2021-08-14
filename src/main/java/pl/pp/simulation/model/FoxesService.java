package pl.pp.simulation.model;

import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panel.ControlPanel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class FoxesService {

    private final List<Fox> foxList = new LinkedList<>();
    private final List<Fox> newFoxList = new LinkedList<>();
    private final List<Fox> deathFoxList = new LinkedList<>();


    public void move() {
        getNewFoxList().clear();
        getDeathFoxList().clear();
        for (Fox fox : getFoxList()) {
            fox.move();
        }
        getFoxList().addAll(newFoxList);
        getFoxList().removeAll(deathFoxList);
    }

    public void updateAmount() {
        int foxAmount = foxList.size();
        ControlPanel.foxParameter.setValue(foxAmount);
        SimulationChart.simulationChart.getFoxSeries().add(steps, foxAmount);
    }

    public void draw(Graphics2D graphics2D) {
        for (Fox grass : foxList) {
            grass.draw(graphics2D);
        }
    }

    public List<Fox> getFoxList() {
        return foxList;
    }


    public List<Fox> getNewFoxList() {
        return newFoxList;
    }

    public List<Fox> getDeathFoxList() {
        return deathFoxList;
    }
}
