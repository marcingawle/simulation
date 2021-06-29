package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.model.Organisms;
import pl.pp.simulation.ui.panel.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panel.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    private static final ResetButton RESET_BUTTON = new ResetButton("Reset");

    public static ResetButton getInstance() {
        return RESET_BUTTON;
    }

    private ResetButton(String text) {
        super(text);

        addActionListener(e -> {
            running = false;
            started = false;

            textArea.setText("");

            simulationChart.clear();

            timer.stop();

            Organisms.clear();

            StopButton.getInstance().setEnabled(false);
            StartButton.getInstance().setEnabled(true);

            ControlPanel.setEditableParameters();

            steps = 0;
            ControlPanel.timeLabel.setText("Czas: 0");

        });
    }
}
