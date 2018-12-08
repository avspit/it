package ru.shestakov.models;

import java.util.ArrayList;
import java.util.List;

public class RKManager {
    private static final int LIMIT_BY_DEFAULT = 20;
    private static final double Y0_BY_DEFAULT = 2.0;
    private static final double STEP_BY_DEFAULT = 0.1;
    private static final double FROM_BY_DEFAULT = 0;
    private static final double TO_BY_DEFAULT = 2;
    private int limit;
    private double y0;
    private double step;
    private double from;
    private double to;
    private List<RKEntity> rungeKuttaCalculations = new ArrayList<>();
    private List<RKEntity> funcCalculations = new ArrayList<>();

    public List<RKEntity> getRungeKuttaCalculations() {
        return this.rungeKuttaCalculations;
    }

    public List<RKEntity> getFuncCalculations() {
        return this.funcCalculations;
    }

    public void integrate(String text) {
        loadParams(text.replaceAll(" ","").split(","));
        calculate();
    }

    public void integrate(double... params) {
        loadParams(params);
        calculate();
    }

    private void loadParams(String[] arr) {
        boolean allParametersAreInput = arr.length == 5;
        this.y0 = allParametersAreInput ? Double.parseDouble(arr[0]) : this.Y0_BY_DEFAULT;
        this.step = allParametersAreInput ? Double.parseDouble(arr[1]) : this.STEP_BY_DEFAULT;
        this.from = allParametersAreInput ? Double.parseDouble(arr[2]) : this.FROM_BY_DEFAULT;
        this.to = allParametersAreInput ? Double.parseDouble(arr[3]) : this.TO_BY_DEFAULT;
        this.limit = allParametersAreInput ? Integer.parseInt(arr[4]) : this.LIMIT_BY_DEFAULT;
    }

    private void loadParams(double... params) {
        boolean allParametersAreInput = params.length == 5;
        this.y0 = allParametersAreInput ? params[0] : this.Y0_BY_DEFAULT;
        this.step = allParametersAreInput ? params[1] : this.STEP_BY_DEFAULT;
        this.from = allParametersAreInput ? params[2] : this.FROM_BY_DEFAULT;
        this.to = allParametersAreInput ? params[3] : this.TO_BY_DEFAULT;
        this.limit = allParametersAreInput ? (int) params[4] : this.LIMIT_BY_DEFAULT;
    }

    private double func(double x, double y) {
        return x + y;
    }

    private void calculate() {
        double step = (this.to - this.from) / this.limit;
        double y = this.y0;
        double deltaY = 0;
        for (int i=0; i<=this.limit; i++) {
            double x = this.from + step * i;
            double k1 = func(x, y);
            double k2 = func(x + this.step / 2, y + (this.step * k1 / 2));
            double k3 = func(x + this.step / 2, y + (this.step * k2 / 2));
            double k4 = func(x + this.step, y + this.step * k3);
            deltaY = this.step / 6 * (k1 + 2*k2 + 2*k3 + k4);
            this.rungeKuttaCalculations.add(new RKEntity(x,y,k1,k2,k3,k4,deltaY));
            y = y + deltaY;
        }
    }

    public void fillFuncCalculations() {
        this.funcCalculations.add(new RKEntity(0.0, 2));
        this.funcCalculations.add(new RKEntity(0.1, 2.215513));
        this.funcCalculations.add(new RKEntity(0.2, 2.464208));
        this.funcCalculations.add(new RKEntity(0.3, 2.749576));
        this.funcCalculations.add(new RKEntity(0.4, 3.075474));
        this.funcCalculations.add(new RKEntity(0.5, 3.446164));
        this.funcCalculations.add(new RKEntity(0.6, 3.866356));
        this.funcCalculations.add(new RKEntity(0.7, 4.341258));
        this.funcCalculations.add(new RKEntity(0.8, 4.876623));
        this.funcCalculations.add(new RKEntity(0.9, 5.478809));
        this.funcCalculations.add(new RKEntity(1.0, 6.154845));
        this.funcCalculations.add(new RKEntity(1.1, 6.912498));
        this.funcCalculations.add(new RKEntity(1.2, 7.760351));
        this.funcCalculations.add(new RKEntity(1.3, 8.70789));
        this.funcCalculations.add(new RKEntity(1.4, 9.7656));
        this.funcCalculations.add(new RKEntity(1.5, 10.94507));
        this.funcCalculations.add(new RKEntity(1.6, 12.2591));
        this.funcCalculations.add(new RKEntity(1.7, 13.72184));
        this.funcCalculations.add(new RKEntity(1.8, 15.34894));
        this.funcCalculations.add(new RKEntity(1.9, 17.15768));
        this.funcCalculations.add(new RKEntity(2.0, 19.16717));
    }
}
