package org.example;

import org.example.math.Matrix4X4;

public class AffineTransformations {
    private Matrix4X4 transformationMatrix;

    private AffineTransformations() {
        this.transformationMatrix = Matrix4X4.one();
    }

    public static AffineTransformations create() {
        return new AffineTransformations();
    }

    public AffineTransformations scale(double sX, double sY, double sZ) {
        Matrix4X4 scaleMatrix = new Matrix4X4(new double[][]{
                {sX, 0, 0, 0},
                {0, sY, 0, 0},
                {0, 0, sZ, 0},
                {0, 0, 0, 1}
        });
        this.transformationMatrix = this.transformationMatrix.mul(scaleMatrix);
        return this;
    }

    public AffineTransformations rotateX(double rX) {
        double cosX = Math.cos(rX);
        double sinX = Math.sin(rX);

        Matrix4X4 rotationMatrix = new Matrix4X4(new double[][]{
                {1, 0, 0, 0},
                {0, cosX, sinX, 0},
                {0, -sinX, cosX, 0},
                {0, 0, 0, 1}
        });
        this.transformationMatrix = this.transformationMatrix.mul(rotationMatrix);
        return this;
    }

    public AffineTransformations rotateY(double rY) {
        double cosY = Math.cos(rY);
        double sinY = Math.sin(rY);

        Matrix4X4 rotationMatrix = new Matrix4X4(new double[][]{
                {cosY, 0, sinY, 0},
                {0, 1, 0, 0},
                {-sinY, 0, cosY, 0},
                {0, 0, 0, 1}
        });
        this.transformationMatrix = this.transformationMatrix.mul(rotationMatrix);
        return this;
    }

    public AffineTransformations rotateZ(double rZ) {
        double cosZ = Math.cos(rZ);
        double sinZ = Math.sin(rZ);

        Matrix4X4 rotationMatrix = new Matrix4X4(new double[][]{
                {cosZ, sinZ, 0, 0},
                {-sinZ, cosZ, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
        this.transformationMatrix = this.transformationMatrix.mul(rotationMatrix);
        return this;
    }

    public AffineTransformations translate(double tX, double tY, double tZ) {
        Matrix4X4 translationMatrix = new Matrix4X4(new double[][]{
                {1, 0, 0, tX},
                {0, 1, 0, tY},
                {0, 0, 1, tZ},
                {0, 0, 0, 1}
        });

        this.transformationMatrix = this.transformationMatrix.mul(translationMatrix);
        return this;
    }

    public Matrix4X4 build() {
        return this.transformationMatrix;
    }
}