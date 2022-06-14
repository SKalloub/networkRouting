package com.example.algoproject;

import java.util.ArrayList;

public class vertex implements Comparable<vertex>{
    private int index;
    private double X;
    private double Y;
    private double cost;
    private boolean visited;
    private vertex path;
    private ArrayList<adjacent> adjacents;
    public vertex(int index, double X, double Y){
        this.index = index;
        this.X = X;
        this.Y = Y;
        adjacents = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public ArrayList<adjacent> getAdjacents() {
        return adjacents;
    }

    public void setAdjacents(ArrayList<adjacent> adjacents) {
        this.adjacents = adjacents;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public vertex getPath() {
        return path;
    }

    public void setPath(vertex path) {
        this.path = path;
    }

    @Override
    public int compareTo(vertex o) {
        return this.cost > o.cost ? 1 : (int) (this.cost-o.cost);
    }
}
