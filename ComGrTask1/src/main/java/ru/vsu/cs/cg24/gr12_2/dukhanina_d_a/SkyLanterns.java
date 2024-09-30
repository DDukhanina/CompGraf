package ru.vsu.cs.cg24.gr12_2.dukhanina_d_a;

import java.awt.*;

public class SkyLanterns {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color c;

    public SkyLanterns(int x, int y, int w, int h, Color c) {
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
        g.setColor(c);
        g.fillOval(x, y + h / 4 - 5, w, h / 2);

        int[] x1Points = {x, x + w, x + w - w / 3, x + w / 3};
        int[] y1Points = {y + h / 2, y + h / 2, y + h, y + h};
        g.setColor(c);
        g.fillPolygon(x1Points, y1Points, 4);

        int[] x2Points = {x + w / 2, x + 17 * w / 30, x + 13 * w / 30};
        int[] y2Points = {y + 8 * h / 9, y + h, y + h};
        g.setColor(new Color(250, 250, 150));
        g.fillPolygon(x2Points, y2Points, 3);
    }
}
