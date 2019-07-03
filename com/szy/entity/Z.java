package com.szy.entity;

/**
 * Z
 */
public class Z {

    public static double getZ(double E, double H, double a_e, double a_h, double A_e, double A_h) {
        double Z = Math.pow(E, 2.0) / ((1.0 + a_e) * A_e) + Math.pow(H, 2.0) / ((1.0 + a_h) * A_h);
        return Z;
    }
}