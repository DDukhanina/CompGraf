package ru.vsu.cs.cg24.gr12_2.dukhanina_d_a;

import java.awt.*;

public class Background {
    private int w;
    private int h;
    private int yField;
    private Color cSky;
    private Color cField;

    public Background(int w, int h, int yField, Color cSky, Color cField) {
        this.w = w;
        this.h = h;
        this.yField = yField;
        this.cField = cField;
        this.cSky = cSky;
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

    public int getyField() {
        return yField;
    }

    public void setyField(int yField) {
        this.yField = yField;
    }

    public Color getcSky() {
        return cSky;
    }

    public void setcSky(Color cSky) {
        this.cSky = cSky;
    }

    public Color getcField() {
        return cField;
    }

    public void setcField(Color cField) {
        this.cField = cField;
    }

    public void Draw(Graphics2D g) {
        g.setColor(cSky);
        g.fillRect(0, 0, w, h);

        g.setColor(cField);
        g.fillRect(0, yField, w, h);
    }
}
