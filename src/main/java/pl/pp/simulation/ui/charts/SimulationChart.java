package pl.pp.simulation.ui.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class SimulationChart extends JFrame {

    private XYSeries hareSeries;
    private XYSeries grassSeries;
    private XYSeries foxSeries;

    public SimulationChart() {
        System.out.println("konstrukrot - SimulationChart");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Wykres");

        XYSeriesCollection dataset = getDataSet();
        JFreeChart freeChart = getChart(dataset);

        ChartPanel chartPanel = new ChartPanel(freeChart);

        add(chartPanel);
        pack();
    }

    private JFreeChart getChart(XYSeriesCollection dataset) {
        return ChartFactory.createXYLineChart(
                "Ilość organizmów w zależeności od czasu",
                "czas",
                "ilosć",
                dataset
        );
    }

    private XYSeriesCollection getDataSet() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        hareSeries = new XYSeries("zające");
        grassSeries = new XYSeries("trawa");
        foxSeries = new XYSeries("lisy");

        dataset.addSeries(hareSeries);
        dataset.addSeries(grassSeries);
        dataset.addSeries(foxSeries);
        return dataset;
    }

    public XYSeries getHareSeries() {
        return hareSeries;
    }

    public XYSeries getGrassSeries() {
        return grassSeries;
    }

    public XYSeries getFoxSeries() {
        return foxSeries;
    }

    public void clear() {
        grassSeries.clear();
        hareSeries.clear();
        foxSeries.clear();

    }
}

