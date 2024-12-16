package cs.affinetransformation;

import cs.affinetransformation.math.Matrix4X4;
import cs.affinetransformation.math.Vector3f;
import cs.affinetransformation.math.Vector4f;
import cs.affinetransformation.model.Model;
import java.util.ArrayList;

public class ATTransformator {

    private Matrix4X4 transformationMatrix;

    private ATTransformator(Matrix4X4 transformationMatrix) {
        this.transformationMatrix = new Matrix4X4(transformationMatrix.getData());
    }

    public Vector3f applyTransformationToVector(Vector3f vector) {
        Vector4f fourVector = new Vector4f(new double[]{vector.getX(), vector.getY(), vector.getZ(), 1});
        Vector4f transformedVector = transformationMatrix.mul(fourVector);
        if (transformedVector.getW() == 0) {
            return new Vector3f(new double[]{transformedVector.getX(), transformedVector.getY(), transformedVector.getZ()});
        } else {
            return new Vector3f(new double[]{transformedVector.getX()/transformedVector.getW(), transformedVector.getY()/transformedVector.getW(), transformedVector.getZ()/transformedVector.getW()});
        }
    }

    public ArrayList<Vector3f> applyTransformationToVectorList(ArrayList<Vector3f> vectorList) {
        ArrayList<Vector3f> transformedVectorList = new ArrayList<>();
        for (Vector3f vector : vectorList) {
            transformedVectorList.add(applyTransformationToVector(vector));
        }
        return transformedVectorList;
    }

    public Model applyTransformationToModel(Model originalModel) {
        Model transformedModel = new Model();

        for (Vector3f vertex : originalModel.vertices) {
            transformedModel.vertices.add(applyTransformationToVector(vertex));
        }

        transformedModel.textureVertices.addAll(originalModel.textureVertices);
        transformedModel.normals.addAll(originalModel.normals);
        transformedModel.polygons.addAll(originalModel.polygons);

        return transformedModel;
    }

    public static class ATBuilder {
        private Matrix4X4 currentMatrix;

        public ATBuilder() {
            this.currentMatrix = Matrix4X4.one();
        }

        private ATBuilder scale(double sX, double sY, double sZ) {
            Matrix4X4 scaleMatrix = new Matrix4X4(new double[][]{
                    {sX, 0, 0, 0},
                    {0, sY, 0, 0},
                    {0, 0, sZ, 0},
                    {0, 0, 0, 1}
            });
            this.currentMatrix = this.currentMatrix.mul(scaleMatrix);
            return this;
        }

        private ATBuilder rotateX(double rX) {
            double cosX = Math.cos(rX);
            double sinX = Math.sin(rX);

            Matrix4X4 rotationMatrix = new Matrix4X4(new double[][]{
                    {1, 0, 0, 0},
                    {0, cosX, sinX, 0},
                    {0, -sinX, cosX, 0},
                    {0, 0, 0, 1}
            });
            this.currentMatrix = this.currentMatrix.mul(rotationMatrix);
            return this;
        }

        private ATBuilder rotateY(double rY) {
            double cosY = Math.cos(rY);
            double sinY = Math.sin(rY);

            Matrix4X4 rotationMatrix = new Matrix4X4(new double[][]{
                    {cosY, 0, sinY, 0},
                    {0, 1, 0, 0},
                    {-sinY, 0, cosY, 0},
                    {0, 0, 0, 1}
            });
            this.currentMatrix = this.currentMatrix.mul(rotationMatrix);
            return this;
        }

        private ATBuilder rotateZ(double rZ) {
            double cosZ = Math.cos(rZ);
            double sinZ = Math.sin(rZ);

            Matrix4X4 rotationMatrix = new Matrix4X4(new double[][]{
                    {cosZ, sinZ, 0, 0},
                    {-sinZ, cosZ, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
            });
            this.currentMatrix = this.currentMatrix.mul(rotationMatrix);
            return this;
        }

        private ATBuilder translate(double tX, double tY, double tZ) {
            Matrix4X4 translationMatrix = new Matrix4X4(new double[][]{
                    {1, 0, 0, tX},
                    {0, 1, 0, tY},
                    {0, 0, 1, tZ},
                    {0, 0, 0, 1}
            });

            this.currentMatrix = this.currentMatrix.mul(translationMatrix);
            return this;
        }

        public ATBuilder scaleByX(double sX) {
            return scale(sX, 1, 1);
        }

        public ATBuilder scaleByY(double sY) {
            return scale(1, sY, 1);
        }

        public ATBuilder scaleByZ(double sZ) {
            return scale(1, 1, sZ);
        }

        public ATBuilder scaleByVertor(Vector3f vector) {
            return scale(vector.getX(), vector.getY(), vector.getZ());
        }

        public ATBuilder scaleByCoordinates(double sX, double sY, double sZ) {
            return scale(sX, sY, sZ);
        }

        public ATBuilder translateByX(double tX) {
            return translate(tX, 0, 0);
        }

        public ATBuilder translateByY(double tY) {
            return translate(0, tY, 0);
        }

        public ATBuilder translateByZ(double tZ) {
            return translate(0, 0, tZ);
        }

        public ATBuilder translateByVector(Vector3f vector) {
            return translate(vector.getX(), vector.getY(), vector.getZ());
        }

        public ATBuilder translateByCoordinates(double tX, double tY, double tZ) {
            return translate(tX, tY, tZ);
        }

        public ATBuilder rotateByX(double rX) {
            return rotateX(rX);
        }

        public ATBuilder rotateByY(double rY) {
            return rotateY(rY);
        }

        public ATBuilder rotateByZ(double rZ) {
            return rotateZ(rZ);
        }

        public ATTransformator build() {
            return new ATTransformator(currentMatrix);
        }
    }


    @Override
    public String toString() {
        return transformationMatrix.toString();
    }

    public void clean() {
        this.transformationMatrix = new Matrix4X4(Matrix4X4.one().getData());
    }
}