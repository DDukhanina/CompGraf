package ru.vsu.cs.gr12_2.dda;

import java.util.ArrayList;

public abstract class Curve{
    private ArrayList<Double> PointsX;
    private ArrayList<Double> PointsY;

    public Curve(ArrayList<Double> pointsX, ArrayList<Double> pointsY) {
        PointsX = pointsX;
        PointsY = pointsY;
    }

    public ArrayList<Double> getPointsX() {
        return PointsX;
    }

    public void setPointsX(ArrayList<Double> pointsX) {
        PointsX = pointsX;
    }

    public ArrayList<Double> getPointsY() {
        return PointsY;
    }

    public void setPointsY(ArrayList<Double> pointsY) {
        PointsY = pointsY;
    }

    public abstract double calculatePoint(ArrayList<Double> points, double t);
}
