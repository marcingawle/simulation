package pl.pp.simulation.ui;

import pl.pp.simulation.model.Foxes;
import pl.pp.simulation.model.GrassUtils;
import pl.pp.simulation.model.Hares;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class SimulationComponent extends JComponent {

    public SimulationComponent() {
        System.out.println("konstrukrot - SimulationComponent");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        Graphics2D graphics2D = (Graphics2D) g;


        Rectangle limit = new Rectangle(0, 0, ProgramData.maxWidth, ProgramData.maxHeight);
        graphics2D.setPaint(Color.LIGHT_GRAY);
        graphics2D.fill(limit);

        draw(graphics2D);

    }

    public void draw(Graphics2D graphics2D) {
        Hares.draw(graphics2D);
        GrassUtils.draw(graphics2D);
        Foxes.draw(graphics2D);
    }
}