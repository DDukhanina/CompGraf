package org.example;

import ru.cs.vsu.cg2024.matrix.typesMatrix.Matrix4D;
import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void testScaleMethod() {
        AffineTransformations affineTransformations = new AffineTransformations();
        Matrix4D scaleMatrix = affineTransformations.scale(-2.5, 3.7, -4.2);
        assertEquals(-2.5, scaleMatrix.get(0, 0), 0.01);
        assertEquals(3.7, scaleMatrix.get(1, 1), 0.01);
        assertEquals(-4.2, scaleMatrix.get(2, 2), 0.01);
    }

    @org.junit.Test
    public void testRotateXMethod() {
        AffineTransformations affineTransformations = new AffineTransformations();
        Matrix4D rotationMatrix = affineTransformations.rotate(2, 0, 0);
        assertEquals(1, rotationMatrix.get(0, 0), 0.01);
        assertEquals(-0.42, rotationMatrix.get(1, 1), 0.01);
        assertEquals(0.91, rotationMatrix.get(1, 2), 0.01);
        assertEquals(-0.91, rotationMatrix.get(2, 1), 0.01);
        assertEquals(-0.42, rotationMatrix.get(2, 2), 0.01);
    }

    @org.junit.Test
    public void testRotateYMethod() {
        AffineTransformations affineTransformations = new AffineTransformations();
        Matrix4D rotationMatrix = affineTransformations.rotate(0, 2, 0);
        assertEquals(1, rotationMatrix.get(1, 1), 0.01);
        assertEquals(-0.42, rotationMatrix.get(0, 0), 0.01);
        assertEquals(0.91, rotationMatrix.get(0, 2), 0.01);
        assertEquals(-0.91, rotationMatrix.get(2, 0), 0.01);
        assertEquals(-0.42, rotationMatrix.get(2, 2), 0.01);
    }

    @org.junit.Test
    public void testRotateZMethod() {
        AffineTransformations affineTransformations = new AffineTransformations();
        Matrix4D rotationMatrix = affineTransformations.rotate(0, 0, 2);
        assertEquals(1, rotationMatrix.get(2, 2), 0.01);
        assertEquals(-0.42, rotationMatrix.get(0, 0), 0.01);
        assertEquals(0.91, rotationMatrix.get(0, 1), 0.01);
        assertEquals(-0.91, rotationMatrix.get(1, 0), 0.01);
        assertEquals(-0.42, rotationMatrix.get(1, 1), 0.01);
    }

    @org.junit.Test
    public void testTranslateMethod() {
        AffineTransformations affineTransformations = new AffineTransformations();
        Matrix4D translationMatrix = affineTransformations.translate(-5.5, 6.3, -7.1);
        assertEquals(-5.5, translationMatrix.get(0, 3), 0.01);
        assertEquals(6.3, translationMatrix.get(1, 3), 0.01);
        assertEquals(-7.1, translationMatrix.get(2, 3), 0.01);
    }
}
