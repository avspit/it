package ru.shestakov.models;

import java.util.ArrayList;
import java.util.List;

public class RKManager {
    private static final int LIMIT_BY_DEFAULT = 20;
    private static final double Y0_BY_DEFAULT = 2.0;
    private static final double STEP_BY_DEFAULT = 0.1;
    private static final double FROM_BY_DEFAULT = 0;
    private static final double TO_BY_DEFAULT = 1;
    private int limit;
    private double y0;
    private double step;
    private double from;
    private double to;
    private List<RKEntity> rungeKutta = new ArrayList<>();

    public void loadParams(String text) {
        String[] arr = text.replaceAll(" ","").split(",");
        boolean allParametersAreInput = arr.length == 5;
        this.y0 = allParametersAreInput ? Double.parseDouble(arr[0]) : this.Y0_BY_DEFAULT;
        this.step = allParametersAreInput ? Double.parseDouble(arr[1]) : this.STEP_BY_DEFAULT;
        this.from = allParametersAreInput ? Double.parseDouble(arr[2]) : this.FROM_BY_DEFAULT;
        this.to = allParametersAreInput ? Double.parseDouble(arr[3]) : this.TO_BY_DEFAULT;
        this.limit = allParametersAreInput ? Integer.parseInt(arr[4]) : this.LIMIT_BY_DEFAULT;
    }

    private double func(double x, double y) {
        return x + y;
    }

    public void calculate() {
        double step = (this.to - this.from) / this.limit;
        for (int i=0; i<this.limit; i++) {
            double x = this.from + step * i;
            double k1 = func(x, this.y0);
            double k2 = func(x + this.step / 2, this.y0 + (this.step * k1 / 2));
            double k3 = func(x + this.step / 2, this.y0 + (this.step * k2 / 2));
            double k4 = func(x + this.step, this.y0 + this.step * k3);
            double deltaY = this.step / 6 * (k1 + 2*k2 + 2*k3 + k4);
            double y = this.y0 + deltaY;
            this.rungeKutta.add(new RKEntity(x,y,k1,k2,k3,k4,deltaY));
        }
    }
}
