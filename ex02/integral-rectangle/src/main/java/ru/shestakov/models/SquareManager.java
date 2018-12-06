package ru.shestakov.models;

public class SquareManager {

    public double integrate(String text) {
        return сalculate(text.replaceAll(" ","").split(","));
    }

    private double сalculate(String[] params) {
        return calculateAtMidpoint(Integer.parseInt(params[3]), Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2]));
    }

    public double сalculate(double... params) {
        return calculateAtMidpoint(params);
    }

    private double func(double exponent, double x) {
        return Math.pow(x, exponent);
    }

    private double calculateAtMidpoint(double... params) {
        double result = 0;
        double exponent = params[0], sectionFrom = params[1], sectionTo = params[2], limit = (int) params[3];
        double step = (sectionTo - sectionFrom) / limit;
        for (int i=0; i<limit; i++) {
            result += func(exponent, sectionFrom + step * (i + 0.5));
        }
        return result *= step;
    }

}
