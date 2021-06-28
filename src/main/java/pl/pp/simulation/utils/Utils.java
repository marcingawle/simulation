package pl.pp.simulation.utils;

import pl.pp.simulation.model.Hare;
import pl.pp.simulation.model.Organism;

import static pl.pp.simulation.utils.ProgramData.newHareList;
import static pl.pp.simulation.utils.Components.*;

public class Utils {
    public static double getDistance(Organism organism1, Organism organism2) {
        double deltaX = organism1.getX() - organism2.getX();
        double deltaY = organism1.getY() - organism2.getY();

        return Math.hypot(deltaX, deltaY);
    }

    public static void multiple(Hare hare1, Hare hare2) {
        hare1.clearDesireForParenthood();
        hare2.clearDesireForParenthood();

        newHareList.add(new Hare(hare1.getX(), hare1.getY()));

        textArea.append("\n Rozmnożenie zająców");
    }
}
