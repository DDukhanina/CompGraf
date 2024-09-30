package ru.vsu.cs.cg24.gr12_2.dukhanina_d_a;

import java.awt.*;

public class Moon {
    private int x;
    private int y;
    private int r;
    private Color c;
    private Color ccrater;

    public Moon(int x, int y, int r, Color c, Color ccrater) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.ccrater = ccrater;
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
        g.setPaint(ccrater);
        g.fillOval(x - r / 2, y - r / 3, r / 2, r / 2);
        g.fillOval(x - r / 12, y - 5 * r / 6, r / 4, r / 4);
        g.fillOval(x + r / 6, y + r / 7, r / 4, r / 4);
        g.fillOval(x - r / 2, y + r / 3, r / 3, r / 3);
        g.fillOval(x + 7 * r / 20, y - r / 3, r / 3, r / 3);
    }
}
