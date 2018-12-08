package ru.shestakov.models;

public class RKEntity {
    private double x;
    private double y;
    private double k1;
    private double k2;
    private double k3;
    private double k4;
    private double deltaY;

    public RKEntity() {
    }

    public RKEntity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public RKEntity(double x, double y, double k1, double k2, double k3, double k4, double deltaY) {
        this.x = x;
        this.y = y;
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.k4 = k4;
        this.deltaY = deltaY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getK1() {
        return k1;
    }

    public void setK1(double k1) {
        this.k1 = k1;
    }

    public double getK2() {
        return k2;
    }

    public void setK2(double k2) {
        this.k2 = k2;
    }

    public double getK3() {
        return k3;
    }

    public void setK3(double k3) {
        this.k3 = k3;
    }

    public double getK4() {
        return k4;
    }

    public void setK4(double k4) {
        this.k4 = k4;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }
}
