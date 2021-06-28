package pl.pp.simulation;

import pl.pp.simulation.model.Fox;
import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;
import pl.pp.simulation.utils.ParameterModel;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.utils.Components.*;
import static pl.pp.simulation.utils.ProgramData.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("Sumulacja drapieżnik - ofiara");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ProgramData.frameWidth, ProgramData.frameHeight);
        setResizable(false);

        JPanel controlPanel = getControlPanel();
        JScrollPane scrollPane = getScrollPane();

        timer = new Step();


        add(myComponent);
        add(controlPanel, BorderLayout.EAST);
        add(scrollPane, BorderLayout.SOUTH);

    }

    private JScrollPane getScrollPane() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(ProgramData.frameWidth, ProgramData.frameHeight - ProgramData.maxHeight -50));
        return scrollPane;
    }

    private JPanel getControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(8, 1, 50, 50));

        controlPanel.setPreferredSize(new Dimension(ProgramData.frameWidth - ProgramData.maxWidth - 50, ProgramData.frameHeight));

        timeLabel = new JLabel("Czas: 0");

        grassParameter = new ParameterModel("Trawa", 50);
        hareParameter = new ParameterModel("Zające", 20);
        foxParameter = new ParameterModel("Lisy", 12);

        initStartButton();
        initStopButton();
        initResetButton();

        JButton chartButton = new JButton("Wykres");

        chartButton.addActionListener(e -> {
            simulationChart.setVisible(true);
        });

        controlPanel.add(timeLabel);
        controlPanel.add(grassParameter.getPanel());
        controlPanel.add(hareParameter.getPanel());
        controlPanel.add(foxParameter.getPanel());
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);
        controlPanel.add(chartButton);
        return controlPanel;
    }

    private void initResetButton() {
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            running = false;
            started = false;

            textArea.setText("");

            simulationChart.getGrassSeries().clear();
            simulationChart.getHareSeries().clear();
            simulationChart.getFoxSeries().clear();

            timer.stop();

            grassList.clear();
            hareList.clear();
            foxList.clear();

            stopButton.setEnabled(false);
            startButton.setEnabled(true);

            grassParameter.setEditable(true);
            hareParameter.setEditable(true);
            foxParameter.setEditable(true);

            steps = 0;
            timeLabel.setText("Czas: 0");

        });
    }

    private void initStopButton() {
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(e -> {
            running = false;
            stopButton.setEnabled(false);
            startButton.setEnabled(true);
            timer.stop();
        });
    }

    private void initStartButton() {
        startButton = new JButton("Start");
        startButton.addActionListener(e -> {

            if (!started) {
                for (int i = 0; i< hareParameter.getValue(); i++) {
                    hareList.add(new Hare());
                }

                for (int i = 0; i< grassParameter.getValue(); i++) {
                    grassList.add(new Grass());
                }

                for (int i = 0; i< foxParameter.getValue(); i++) {
                    foxList.add(new Fox());
                }
            }
            running = true;
            started = true;

            stopButton.setEnabled(true);
            startButton.setEnabled(false);

            grassParameter.setEditable(false);
            hareParameter.setEditable(false);
            foxParameter.setEditable(false);

            timer.start();
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyFrame myFrame = new MyFrame();
            myFrame.setVisible(true);
        });

    }
}