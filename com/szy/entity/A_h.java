package com.szy.entity;

/**
 * A_h
 */
public class A_h {
    public static double getA_h(double[] u_h_array) {
        double A_h = 0;
        for (double u_h : u_h_array) {
            A_h += 1.0 / u_h;
        }
        return A_h;
    }
}