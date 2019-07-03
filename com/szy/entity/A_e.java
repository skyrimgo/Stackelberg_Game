package com.szy.entity;

/**
 * A_e
 */
public class A_e {
    public static double getA_e(double[] u_e_array) {
        double A_e = 0;
        for (double u_e : u_e_array) {
            A_e += 1.0 / u_e;
        }
        return A_e;
    }
}