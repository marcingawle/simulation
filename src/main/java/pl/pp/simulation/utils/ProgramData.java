package pl.pp.simulation.utils;

import pl.pp.simulation.model.Fox;
import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class ProgramData {
    public static int frameWidth = 1400;
    public static int frameHeight = 1050;

    public static int maxWidth = 1200;
    public static int maxHeight = 900;

    public static boolean started = false;
    public static boolean running = false;

    public static Timer timer;
    public static long steps = 0;

    public static List<Hare> hareList = new LinkedList<>();
    public static List<Hare> newHareList = new LinkedList<>();
    public static List<Hare> deathHareList = new LinkedList<>();

    public static List<Fox> foxList = new LinkedList<>();
    public static List<Fox> newFoxList = new LinkedList<>();
    public static List<Fox> deathFoxList = new LinkedList<>();

    public static List<Grass> grassList = new LinkedList<>();

}