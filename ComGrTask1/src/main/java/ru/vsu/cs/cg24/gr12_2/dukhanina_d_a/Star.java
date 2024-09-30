package ru.vsu.cs.cg24.gr12_2.dukhanina_d_a;

import java.awt.*;

public class Star {
    private int x;
    private int y;
    private int r;
    private Color c;

    public Star(int x, int y, int r, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void Draw(Graphics2D g) {
        g.setPaint(c);
        g.fillOval(x - r, y - r, r + r, r + r);
    }
}