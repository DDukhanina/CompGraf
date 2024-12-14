package org.example;

import org.example.math.Matrix4X4;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void testScaleMethod() {
        Matrix4X4 scaleMatrix = AffineTransformations.create()
                .scale(-2.5, 3.7, -4.2)
                .build();
        assertEquals(-2.5, scaleMatrix.get(0, 0), 0.01);
        assertEquals(3.7, scaleMatrix.get(1, 1), 0.01);
        assertEquals(-4.2, scaleMatrix.get(2, 2), 0.01);
    }

    @org.junit.Test
    public void testRotateXMethod() {
        Matrix4X4 rotationMatrix = AffineTransformations.create()
                .rotateX(2)
                .build();
        assertEquals(1, rotationMatrix.get(0, 0), 0.01);
        assertEquals(-0.42, rotationMatrix.get(1, 1), 0.01);
        assertEquals(0.91, rotationMatrix.get(1, 2), 0.01);
        assertEquals(-0.91, rotationMatrix.get(2, 1), 0.01);
        assertEquals(-0.42, rotationMatrix.get(2, 2), 0.01);
    }

    @org.junit.Test
    public void testRotateYMethod() {
        Matrix4X4 rotationMatrix = AffineTransformations.create()
                .rotateY(2)
                .build();
        assertEquals(1, rotationMatrix.get(1, 1), 0.01);
        assertEquals(-0.42, rotationMatrix.get(0, 0), 0.01);
        assertEquals(0.91, rotationMatrix.get(0, 2), 0.01);
        assertEquals(-0.91, rotationMatrix.get(2, 0), 0.01);
        assertEquals(-0.42, rotationMatrix.get(2, 2), 0.01);
    }

    @org.junit.Test
    public void testRotateZMethod() {
        Matrix4X4 rotationMatrix = AffineTransformations.create()
                .rotateZ(2)
                .build();
        assertEquals(1, rotationMatrix.get(2, 2), 0.01);
        assertEquals(-0.42, rotationMatrix.get(0, 0), 0.01);
        assertEquals(0.91, rotationMatrix.get(0, 1), 0.01);
        assertEquals(-0.91, rotationMatrix.get(1, 0), 0.01);
        assertEquals(-0.42, rotationMatrix.get(1, 1), 0.01);
    }

    @org.junit.Test
    public void testTranslateMethod() {
        Matrix4X4 translationMatrix = AffineTransformations.create()
                .translate(-5.5, 6.3, -7.1)
                .build();
        assertEquals(-5.5, translationMatrix.get(0, 3), 0.01);
        assertEquals(6.3, translationMatrix.get(1, 3), 0.01);
        assertEquals(-7.1, translationMatrix.get(2, 3), 0.01);
    }
}