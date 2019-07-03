package com.szy.entity;

/**
 * X
 */
public class X {
    public static double getX(double D, double F, double a_e, double a_h, double A_e, double A_h) {
        double X = Math.pow(D, 2) / ((1.0 + a_e) * A_e) + Math.pow(F, 2.0) / ((1.0 + a_h) * A_h);
        return X;
    }
}