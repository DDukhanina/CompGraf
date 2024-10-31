package ru.vsu.cs.gr12_2.dda;

import java.util.ArrayList;

public class BezierCurve extends Curve{
    public BezierCurve(ArrayList<Double> pointsX, ArrayList<Double> pointsY) {
        super(pointsX, pointsY);
    }

    public double calculatePoint(ArrayList<Double> points, double t) {//x(t) = Cn0*t^0*(1-t)^n*x0 + Cn1*t^1(1-t)^(n-1)*x1 +... + Cnn*t^n*(1-t)^0*xn
        int n = points.size();
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += binomialCoefficient(n - 1, i) * Math.pow(1 - t, n - 1 - i) * Math.pow(t, i) * points.get(i);
        }
        return result;
    }

    private int binomialCoefficient(int n, int k) {
        int[][] binCoeff = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            binCoeff[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                binCoeff[i][j] = binCoeff[i - 1][j - 1] + binCoeff[i - 1][j];
            }
        }

        return binCoeff[n][k];
    }
}
