package com.szy.entity;

/**
 * B_e
 */
public class B_e {

    public static double getB_e(double[] v_e_array, double[] u_e_array) {
        double B_e = 0;
        for (int i = 0; i < v_e_array.length; i++) {
            B_e += v_e_array[i] / u_e_array[i];
        }
        return B_e;
    }
}