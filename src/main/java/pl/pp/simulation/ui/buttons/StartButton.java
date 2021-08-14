package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.*;
import pl.pp.simulation.ui.panel.ControlPanel;
import pl.pp.simulation.utils.ParameterModel;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class StartButton extends JButton {

    public ParameterModel grassParameter = ControlPanel.grassParameter;
    public ParameterModel hareParameter = ControlPanel.hareParameter;
    public ParameterModel foxParameter = ControlPanel.foxParameter;

    public StartButton(StopButton stopButton, Step timer, String text) {
        super(text);
        System.out.println("Konstruktor - StartButton");

        addActionListener(e -> {

            if (!started) {
                init();
            }
            running = true;
            started = true;

            stopButton.setEnabled(true);
            setEnabled(false);

            ControlPanel.setNotEditableParameters();

            timer.start();
        });
    }

    public void init() {
        for (int i = 0; i < hareParameter.getValue(); i++) {
            Hares.hareList.add(new Hare());
        }

        for (int i = 0; i < grassParameter.getValue(); i++) {
            GrassUtils.grassList.add(new Grass());
        }

        for (int i = 0; i < foxParameter.getValue(); i++) {
            Foxes.foxList.add(new Fox());
        }
    }
}
