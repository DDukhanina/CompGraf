package org.example;

import org.example.math.Matrix4X4;

public class Main {

    public static void main(String[] args) {
        Matrix4X4 justMatrix = AffineTransformations.create().scale(3, 5, 1).translate(3, 5, 5).build();
        System.out.println(justMatrix);
    }
}