package ru.vsu.cs.gr12_2.dda;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CurveDrawer {
    private Curve curve;
    public double height = 900;
    public double width = 1000;
    private GraphicsContext gc;

    public CurveDrawer(Curve curve, GraphicsContext gc) {
        this.curve = curve;
        this.gc = gc;
    }

    private void drawCurveSegment(double tStart, double tEnd) {
        double xStart = curve.calculatePoint(curve.getPointsX(), tStart);
        double yStart = curve.calculatePoint(curve.getPointsY(), tStart);
        double xEnd = curve.calculatePoint(curve.getPointsX(), tEnd);
        double yEnd = curve.calculatePoint(curve.getPointsY(), tEnd);
        double distance = Math.sqrt((xEnd - xStart)*(xEnd - xStart) + (yEnd - yStart)*(yEnd - yStart));

        if (distance > 0.001) {
            double tMid = (tStart + tEnd) / 2;
            drawCurveSegment(tStart, tMid);
            drawCurveSegment(tMid, tEnd);
        } else {
            gc.fillRect(xEnd * width, (1 - yEnd) * height, 1, 1);
        }
    }

    public void draw() {
        gc.clearRect(0, 0, width, height);

        gc.setFill(Color.RED);
        for (int i = 0; i < curve.getPointsX().size(); i++) {
            gc.fillOval(curve.getPointsX().get(i) * width - 2.5, (1 - curve.getPointsY().get(i)) * height - 2.5, 5, 5);
        }

        gc.setStroke(Color.GRAY);
        for (int i = 0; i < curve.getPointsX().size() - 1; i++) {
            double x1 = curve.getPointsX().get(i) * width;
            double y1 = (1 - curve.getPointsY().get(i)) * height;
            double x2 = curve.getPointsX().get(i + 1) * width;
            double y2 = (1 - curve.getPointsY().get(i + 1)) * height;
            gc.strokeLine(x1, y1, x2, y2);
        }

        gc.setFill(Color.BLUE);
        drawCurveSegment(0, 1);
    }
}