package com.szy.entity;

/**
 * D_h
 */
public class D_h {

    public static double ghtD_h(double v_h, double u_h, double p_h) {
        double D_h = v_h / u_h - 1.0 / u_h * p_h;
        return D_h;
    }
}