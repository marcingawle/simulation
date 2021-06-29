package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.ui.panel.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panel.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    private static final ResetButton resetButton = new ResetButton("Reset");

    public static ResetButton getInstance() {
        return resetButton;
    }

    private ResetButton(String text) {
        super(text);

        addActionListener(e -> {
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

            StopButton.getInstance().setEnabled(false);
            StartButton.getInstance().setEnabled(true);

            ControlPanel.grassParameter.setEditable(true);
            ControlPanel.hareParameter.setEditable(true);
            ControlPanel.foxParameter.setEditable(true);

            steps = 0;
            ControlPanel.timeLabel.setText("Czas: 0");

        });
    }
}
