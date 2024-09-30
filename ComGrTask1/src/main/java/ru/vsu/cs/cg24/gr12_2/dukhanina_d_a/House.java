package ru.vsu.cs.cg24.gr12_2.dukhanina_d_a;

import java.awt.*;

public class House {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color c;

    public House(int x, int y, int w, int h, Color c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void Draw(Graphics2D g) {
        int[] xPoints = {x, x + w / 2, x + w, x - w / 2};
        int[] yPoints = {y, y, y + h / 2, y + h / 2};
        g.setColor(c);
        g.fillPolygon(xPoints, yPoints, 4);

        g.setColor(Color.yellow);
        g.fillRect(x - w / 13, y + h / 5, w / 5, h / 5);

        g.setColor(Color.orange);
        g.drawRect(x - w / 13, y + h / 5, w / 5, h / 5);

        g.setColor(Color.black);
        g.fillRect(x + 4, y + h / 5, 2, h / 5);
        g.fillRect(x - w / 13, y + h / 3, w / 5, 2);
    }
}
