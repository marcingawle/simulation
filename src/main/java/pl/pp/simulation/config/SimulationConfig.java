package pl.pp.simulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pp.simulation.Step;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panel.ControlPanel;
import pl.pp.simulation.ui.panel.ScrollPanel;
import pl.pp.simulation.utils.ParameterModel;

import javax.swing.*;

@Configuration
public class SimulationConfig {

    @Bean
    public StartButton startButton() {
        StartButton startButton = new StartButton("Start");
        startButton.setStopButton(stopButton());
        startButton.setTimer(timer());

        startButton.setGrassParameter(grassParameter());
        startButton.setHareParameter(hareParameter());
        startButton.setFoxParameter(foxParameter());

        startButton.setGrassService(grassService());
        startButton.setHaresService(haresService());
        startButton.setFoxesService(foxesService());
        return startButton;
    }

    @Bean
    public StopButton stopButton() {
        StopButton stopButton = new StopButton("Stop");
        stopButton.setTimer(timer());
        return stopButton;
    }

    @Bean
    public ResetButton resetButton() {
        ResetButton resetButton = new ResetButton("Reset");
        resetButton.setStartButton(startButton());
        resetButton.setStopButton(stopButton());
        resetButton.setTimer(timer());
        resetButton.setSimulationChart(simulationChart());
        resetButton.setTimeLabel(timeLabel());

        resetButton.setGrassParameter(grassParameter());
        resetButton.setHareParameter(hareParameter());
        resetButton.setFoxParameter(foxParameter());

        resetButton.setGrassService(grassService());
        resetButton.setHaresService(haresService());
        resetButton.setFoxesService(foxesService());
        return resetButton;
    }

    @Bean
    public GrassService grassService() {
        GrassService grassService = new GrassService();
        grassService.setSimulationChart(simulationChart());
        grassService.setGrassParameter(grassParameter());
        return grassService;
    }

    @Bean
    public HaresService haresService() {
        HaresService haresService = new HaresService();
        haresService.setSimulationChart(simulationChart());
        haresService.setHareParameter(hareParameter());
        return haresService;
    }

    @Bean
    public FoxesService foxesService() {
        FoxesService foxesService = new FoxesService();
        foxesService.setSimulationChart(simulationChart());
        foxesService.setFoxParameter(foxParameter());
        return foxesService;
    }

    @Bean
    public ParameterModel grassParameter() {
        return new ParameterModel("Trawa", 50);
    }

    @Bean
    public ParameterModel hareParameter() {
        return new ParameterModel("Zające", 20);
    }

    @Bean
    public ParameterModel foxParameter() {
        return new ParameterModel("Lisy", 12);
    }

    @Bean
    public Step timer() {
        Step step = new Step();
        step.setSimulationComponent(simulationComponent());
        step.setGrassService(grassService());
        step.setHaresService(haresService());
        step.setFoxesService(foxesService());
        step.setTimeLabel(timeLabel());
        return step;
    }

    @Bean
    public JLabel timeLabel() {
        return new JLabel("Czas: 0");
    }

    @Bean
    public ControlPanel controlPanel() {
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setResetButton(resetButton());
        controlPanel.setStartButton(startButton());
        controlPanel.setStopButton(stopButton());
        controlPanel.setSimulationChart(simulationChart());
        controlPanel.setTimeLabel(timeLabel());

        controlPanel.setGrassParameter(grassParameter());
        controlPanel.setHareParameter(hareParameter());
        controlPanel.setFoxParameter(foxParameter());
        return controlPanel;
    }

    @Bean
    public ScrollPanel scrollPanel() {
        return new ScrollPanel();
    }

    @Bean
    public SimulationChart simulationChart() {
        return new SimulationChart();
    }

    @Bean
    public SimulationComponent simulationComponent() {
        SimulationComponent simulationComponent = new SimulationComponent();
        simulationComponent.setGrassService(grassService());
        simulationComponent.setHaresService(haresService());
        simulationComponent.setFoxesService(foxesService());
        return simulationComponent;
    }

    @Bean
    public MyFrame myFrame() {
        MyFrame myFrame = new MyFrame();
        myFrame.setControlPanel(controlPanel());
        myFrame.setScrollPanel(scrollPanel());
        myFrame.setSimulationComponent(simulationComponent());
        return myFrame;
    }
}
