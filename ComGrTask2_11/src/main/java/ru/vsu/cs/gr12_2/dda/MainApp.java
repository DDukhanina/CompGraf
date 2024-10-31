package ru.vsu.cs.gr12_2.dda;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainApp extends Application {
    private ArrayList<Double> controlPointsX = new ArrayList<>();
    private ArrayList<Double> controlPointsY = new ArrayList<>();
    private CurveDrawer drawer;
    public double height = 900;
    public double width = 1000;
    private double dragOffsetX;
    private double dragOffsetY;
    private boolean isDragging = false;
    private int selectedPointIndex = -1;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawer = new CurveDrawer(new BezierCurve(controlPointsX, controlPointsY), gc);

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getClickCount() == 2) {
                removePoint(event.getX(), event.getY());
            } else if (event.getClickCount() == 1) {
                selectOrMovePoint(event.getX(), event.getY());
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            for (int i = 0; i < controlPointsX.size(); i++) {
                double pointX = controlPointsX.get(i) * width;
                double pointY = (1 - controlPointsY.get(i)) * height;
                if (Math.abs(pointX - event.getX()) <= 5 && Math.abs(pointY - event.getY()) <= 5) {
                    selectedPointIndex = i;
                    dragOffsetX = event.getX() - pointX;
                    dragOffsetY = event.getY() - pointY;
                    isDragging = true;
                    break;
                }
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            if (isDragging && selectedPointIndex != -1) {
                controlPointsX.set(selectedPointIndex, (event.getX() - dragOffsetX) / width);
                controlPointsY.set(selectedPointIndex, (height - event.getY() - dragOffsetY) / height);
                drawer.draw();
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            selectedPointIndex = -1;
            isDragging = false;
        });

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void removePoint(double x, double y) {
        for (int i = 0; i < controlPointsX.size(); i++) {
            double pointX = controlPointsX.get(i) * width;
            double pointY = (1 - controlPointsY.get(i)) * height;
            if (Math.abs(pointX - x) <= 5 && Math.abs(pointY - y) <= 5) {
                controlPointsX.remove(i);
                controlPointsY.remove(i);

                drawer.draw();
                break;
            }
        }
    }

    private void selectOrMovePoint(double x, double y) {
        boolean pointSelected = false;
        for (int i = 0; i < controlPointsX.size(); i++) {
            double pointX = controlPointsX.get(i) * width;
            double pointY = (1 - controlPointsY.get(i)) * height;
            if (Math.abs(pointX - x) <= 5 && Math.abs(pointY - y) <= 5) {
                selectedPointIndex = i;
                pointSelected = true;
                break;
            }
        }

        if (!pointSelected) {
            selectPoint(x, y);
        }
        drawer.draw();
    }

    private void selectPoint(double x, double y){
        controlPointsX.add(x / width);
        controlPointsY.add((height - y) / height);
    }

    public static void main(String[] args) {
        launch(args);
    }
}