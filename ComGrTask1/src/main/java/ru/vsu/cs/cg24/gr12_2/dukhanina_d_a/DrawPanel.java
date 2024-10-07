package ru.vsu.cs.cg24.gr12_2.dukhanina_d_a;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class DrawPanel extends JPanel {
    private static Random rnd = new Random();
    private Moon moon;
    private List<Star> stars;
    private List<SkyLanterns> skyLanterns;
    private Background background;
    private House house;

    public DrawPanel() {
        Color ccrater = new Color(200, 200, 200);
        Color csky = new Color(0, 0, 100);
        Color cfield = new Color(0, 0, 20);
        background = new Background(2048, 1024, 800, csky, cfield);
        moon = new Moon(200, 200, rnd.nextInt(80) + 70, Color.white, ccrater);
        house = new House(1000, 700, 300, 250, cfield);
        stars = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            int x = rnd.nextInt(1950) + 50;
            int y = rnd.nextInt(770) + 20;
            Star star = new Star(x, y, 2, Color.white);
            stars.add(star);
        }
        skyLanterns = paintSkyLanterns();
    }

    private List<SkyLanterns> paintSkyLanterns() {
        Random rnd = new Random();
        skyLanterns = new ArrayList<>();
        List<Color> colorList = new ArrayList<>();
        colorList.add(new Color(90, 20, 100));
        colorList.add(new Color(200, 100, 20));
        colorList.add(new Color(171, 30, 100));
        colorList.add(new Color(200, 150, 50));
        colorList.add(new Color(64, 89, 20));
        colorList.add(new Color(170, 30, 10));
        colorList.add(new Color(30, 80, 100));
        colorList.add(new Color(200, 180, 70));
        int[] xList = new int[]{500, 900, 1300, 1600, 700, 1150, 1450, 300, 600, 900, 1100, 1300, 1700, 400, 700, 1500, 100, 1700, 1300, 900};
        int[] yList = new int[]{50, 40, 30, 45, 170, 160, 190, 320, 350, 480, 420, 580, 500, 550, 600, 450, 500, 210, 350, 280};
        for (int i = 0; i < 20; i++) {
            int w = rnd.nextInt(50) + 70;
            int h = w * 3 / 2;
            int randomIndex = rnd.nextInt(colorList.size());
            SkyLanterns skyLantern = new SkyLanterns(xList[i], yList[i], w, h, colorList.get(randomIndex));
            skyLanterns.add(skyLantern);
        }

        return skyLanterns;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        for (SkyLanterns s : skyLanterns){
            s.setY(s.getY() - 1);
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        background.Draw((Graphics2D) g);
        for (Star star : stars) {
            star.Draw((Graphics2D) g);
        }
        house.Draw((Graphics2D) g);
        moon.Draw((Graphics2D) g);
        for (SkyLanterns skyLantern : skyLanterns) {
            skyLantern.Draw((Graphics2D) g);
        }
    }
}