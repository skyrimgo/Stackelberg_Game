package com.szy.entity;

/**
 * D_e
 */
public class D_e {

    public static double getD_e(double v_e, double u_e, double p_e) {
        double D_e = v_e / u_e - 1.0 / u_e * p_e;
        return D_e;
    }
}