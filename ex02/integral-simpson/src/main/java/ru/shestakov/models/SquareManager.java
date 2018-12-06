package ru.shestakov.models;

import java.util.Map;
import java.util.TreeMap;

public class SquareManager {
    private Map<Double,Double> simpsonCalculations = new TreeMap<>(); // uses for print to excel
    private Map<Double,Double> funcCalculations = new TreeMap<>(); // uses for print to excel

    public Map<Double, Double> getSimpsonCalculations() {
        return simpsonCalculations;
    }

    public Map<Double, Double> getFuncCalculations() {
        return funcCalculations;
    }

    public double integrate(String text) {
        return сalculate(text.replaceAll(" ","").split(","));
    }

    private double сalculate(String[] params) {
        return doCalculate(Integer.parseInt(params[3]), Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2]));
    }

    public double сalculate(double... params) {
        return doCalculate(params);
    }

    private double func(double exponent, double x) {
        return Math.pow(x, exponent);
    }

    private double doCalculate(double... params) {
        double result = 0;
        double exponent = params[0], sectionFrom = params[1], sectionTo = params[2], limit = (int) params[3];
        double step = (sectionTo - sectionFrom) / limit;
        double firstResult = func(exponent, sectionFrom);
        double lastResult = func(exponent, sectionTo);
        this.simpsonCalculations.put(sectionFrom, firstResult);
        this.simpsonCalculations.put(sectionTo, lastResult);
        this.funcCalculations.put(sectionFrom, firstResult);
        this.funcCalculations.put(sectionTo, lastResult);
        for (int i=1; i<limit; i++) {
            int ratio = i % 2 == 0 ? 2 : 4;
            double x = sectionFrom + step * i;
            double y = func(exponent, x);
            this.funcCalculations.put(x, y);
            x = simpsonCeiling(x);
            y = simpsonCeiling(y);
            result += ratio * y;
            this.simpsonCalculations.put(x, y);
        }
        return (step / 3) * (result + firstResult + lastResult);
    }

    private double simpsonCeiling(double value) {
        return (double)Math.round(value * 1000d) / 1000d;
    }

}
