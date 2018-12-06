package ru.shestakov.models;

public class SquareManager {

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
        double exponent = params[0], sectionFrom = params[1], sectionTo = params[2], limit = (int) params[3];
        double result = 0, xFrom = sectionFrom, xTo = 0;
        double step = (sectionTo - sectionFrom) / limit;
        for (int i=0; i<limit; i++) {
            xTo = xFrom + step;
            result += (func(exponent, xTo) + func(exponent, xFrom)) * step * 0.5;
            xFrom = xTo;
        }
        return result;
    }

}
