package com.szy.entity;

/**
 * B_h
 */
public class B_h {

    public static double getB_h(double[] v_h_array, double[] u_h_array) {
        double B_h = 0;
        for (int i = 0; i < v_h_array.length; i++) {
            B_h += v_h_array[i] / u_h_array[i];
        }
        return B_h;
    }
}