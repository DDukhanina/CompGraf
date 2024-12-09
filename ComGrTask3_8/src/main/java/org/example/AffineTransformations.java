package org.example;

import ru.cs.vsu.cg2024.matrix.typesMatrix.Matrix4D;

public class AffineTransformations {
    private Matrix4D transformationMatrix;

    public AffineTransformations() {
        this.transformationMatrix = new Matrix4D(new double[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        });
    }

    public Matrix4D scale(double sX, double sY, double sZ) {
        Matrix4D scaleMatrix = new Matrix4D(new double[][]{
                {sX, 0, 0, 0},
                {0, sY, 0, 0},
                {0, 0, sZ, 0},
                {0, 0, 0, 1}
        });
        return scaleMatrix;
    }

    public Matrix4D rotate(double rX, double rY, double rZ) {
        double cosX = Math.cos(rX);
        double sinX = Math.sin(rX);
        double cosY = Math.cos(rY);
        double sinY = Math.sin(rY);
        double cosZ = Math.cos(rZ);
        double sinZ = Math.sin(rZ);

        Matrix4D rotationMatrix = new Matrix4D(new double[][]{
                {cosZ * cosY, cosX * sinZ - sinX * sinY * cosZ, sinX * sinZ + cosX * sinY * cosZ, 0},
                {-sinZ * cosY, cosX * cosZ + sinX * sinY * sinZ, sinX * cosZ - cosX * sinY * sinZ, 0},
                {-sinY, -sinX * cosY, cosX * cosY, 0},
                {0, 0, 0, 1}
        });
        return rotationMatrix;
    }

    public Matrix4D translate(double tX, double tY, double tZ) {
        Matrix4D translationMatrix = new Matrix4D(new double[][]{
                {1, 0, 0, tX},
                {0, 1, 0, tY},
                {0, 0, 1, tZ},
                {0, 0, 0, 1}
        });

        return translationMatrix;
    }
}