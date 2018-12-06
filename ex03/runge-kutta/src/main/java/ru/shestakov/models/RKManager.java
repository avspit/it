package ru.shestakov.models;

import java.util.ArrayList;
import java.util.List;

public class RKManager {
    private static final int LIMIT_BY_DEFAULT = 10;
    private static final double Y0_BY_DEFAULT = 2.0;
    private static final double STEP_BY_DEFAULT = 0.1;
    private static final double FROM_BY_DEFAULT = 0;
    private static final double TO_BY_DEFAULT = 1;
    private int limit;
    private double y0;
    private double step;
    private double from;
    private double to;
    private List<RKEntity> rungeKuttaCalculations = new ArrayList<>();

    public List<RKEntity> getRungeKuttaCalculations() {
        return rungeKuttaCalculations;
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
}
