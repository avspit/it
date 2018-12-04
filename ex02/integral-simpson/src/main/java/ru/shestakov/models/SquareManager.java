package ru.shestakov.models;

import java.util.Map;
import java.util.TreeMap;

public class SquareManager {
    private int limit;
    private Map<String,Double> params = new TreeMap<>();
    private Map<Double,Double> simpsonFunc = new TreeMap<>(); // uses for print to excel
    private Map<Double,Double> func = new TreeMap<>(); // uses for print to excel

    public Map<Double,Double> getSimpsonFunc() {
        return this.simpsonFunc;
    }

    public Map<Double,Double> getFunc() {
        return this.func;
    }

    public void loadParams(String text) {
        String[] arr = text.replaceAll(" ","").split(",");
        this.limit = Integer.parseInt(arr[3]) * 2;
        this.params.put("exponent", Double.parseDouble(arr[0]));
        this.params.put("sectionFrom", Double.parseDouble(arr[1]));
        this.params.put("sectionTo", Double.parseDouble(arr[2]));
    }

    public void loadParams(double... params) {
        this.limit = (int) params[3] * 2;
        this.params.put("exponent", params[0]);
        this.params.put("sectionFrom", params[1]);
        this.params.put("sectionTo", params[2]);
    }

    public double integrate() {
        return calculate();
    }

    private double func(double exponent, double x) {
        return Math.pow(x, exponent);
    }

    public double calculate() {
        double result = 0;
        double exponent = this.params.get("exponent"), sectionFrom = this.params.get("sectionFrom"), sectionTo = this.params.get("sectionTo");
        double step = (sectionTo - sectionFrom) / this.limit;
        double firstResult = func(exponent, sectionFrom);
        double lastResult = func(exponent, sectionTo);
        this.simpsonFunc.put(sectionFrom, firstResult);
        this.simpsonFunc.put(sectionTo, lastResult);
        this.func.put(sectionFrom, firstResult);
        this.func.put(sectionTo, lastResult);
        for (int i=1; i<this.limit; i++) {
            int ratio = i % 2 == 0 ? 2 : 4;
            double x = sectionFrom + step * i;
            double y = func(exponent, x);
            this.func.put(x, y);
            x = simpsonCeiling(x);
            y = simpsonCeiling(y);
            result += ratio * y;
            this.simpsonFunc.put(x, y);
        }
        return (step / 3) * (result + firstResult + lastResult);
    }

    private double simpsonCeiling(double value) {
        return (double)Math.round(value * 1000d) / 1000d;
    }

}
