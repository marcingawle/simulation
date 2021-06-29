package pl.pp.simulation.model;

import pl.pp.simulation.ui.panel.ControlPanel;

import java.awt.*;

public class Organisms {
    public static void clear() {
        GrassUtils.grassList.clear();
        Hares.hareList.clear();
        Foxes.foxList.clear();

    }

    public static void init() {
        for (int i = 0; i < ControlPanel.hareParameter.getValue(); i++) {
            Hares.hareList.add(new Hare());
        }

        for (int i = 0; i < ControlPanel.grassParameter.getValue(); i++) {
            GrassUtils.grassList.add(new Grass());
        }

        for (int i = 0; i < ControlPanel.foxParameter.getValue(); i++) {
            Foxes.foxList.add(new Fox());
        }
    }

    public static void draw(Graphics2D graphics2D) {
        Hares.draw(graphics2D);
        GrassUtils.draw(graphics2D);
        Foxes.draw(graphics2D);
    }

    public static void updateAmount() {
        GrassUtils.updateAmount();
        Hares.updateAmount();
        Foxes.updateAmount();
    }
}
