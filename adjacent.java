package com.example.algoproject;

public class adjacent {
    private vertex v;
    private double distance;

    public adjacent(vertex v, double distance) {
        this.v = v;
        this.distance = distance;
    }

    public vertex getV() {
        return v;
    }

    public void setV(vertex v) {
        this.v = v;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
