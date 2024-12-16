package cs.affinetransformation.math;

public class Matrix4X4 {
    private Matrix matrix;

    public Matrix4X4(double[][] data) {
        if (data.length != 4 || data[0].length != 4) {
            throw new IllegalArgumentException("Матрица должна быть 4X4");
        }
        this.matrix = new Matrix(data);
    }

    public double getAt(int row, int col) {
        return matrix.getAt(row, col);
    }

    public void setAt(int row, int col, float value) {
        matrix.setAt(row, col, value);
    }

    public double[][] getData() {
        return matrix.getData();
    }

    public Matrix4X4() {
        this(new double[4][4]);
    }

    public static Matrix4X4 zero() {
        return new Matrix4X4();
    }

    public static Matrix4X4 one() {
        double[][] oneData = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        return new Matrix4X4(oneData);
    }

    public double get(int row, int col) {
        return getAt(row, col);
    }

    public Matrix4X4 mul(Matrix4X4 other) {
        return new Matrix4X4(matrix.mul(other.matrix).getData());
    }

    public Matrix4X4 mul(double n) {
        return new Matrix4X4(matrix.mul(n).getData());
    }

    public Vector4f mul(Vector4f v) {
        return new Vector4f(matrix.mul(v.vector).getData());
    }

    public void print() {
        matrix.print();
    }

    public Matrix4X4 transposed() {
        return new Matrix4X4(matrix.transposed().getData());
    }

    public Matrix4X4 add(Matrix4X4 other) {
        return new Matrix4X4(matrix.add(other.matrix).getData());
    }

    public Matrix4X4 sub(Matrix4X4 other) {
        return new Matrix4X4(matrix.sub(other.matrix).getData());
    }

    public double determinant() {
        return matrix.determinant(matrix.getData(), 4);
    }

    public Matrix4X4 inversion() {
        return new Matrix4X4(matrix.inversion().getData());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double[][] data = getData();
        for (double[] row : data) {
            for (double val : row) {
                sb.append(String.format("%.3f", val)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}