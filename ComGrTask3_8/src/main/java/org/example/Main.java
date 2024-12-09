package org.example;

import ru.cs.vsu.cg2024.matrix.typesMatrix.Matrix4D;

public class Main {
    public static void main(String[] args) {
        AffineTransformations affineTransformations = new AffineTransformations();

        Matrix4D scaleMatrix = affineTransformations.scale(2, 1.5, 0.5);
        System.out.println(scaleMatrix);


        Matrix4D rotationMatrix = affineTransformations.rotate(1, -1, 2);
        System.out.println(rotationMatrix);


        Matrix4D translationMatrix = affineTransformations.translate(3, -1, 2.5);
        System.out.println(translationMatrix);
    }
}
