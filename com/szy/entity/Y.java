package com.szy.entity;

/**
 * Y
 */
public class Y {

    public static double getY(double D, double E, double F, double H, double a_e, double a_h, double A_e, double A_h) {
        double Y = D * E / ((1.0 + a_e) * A_e) + F * H / ((1.0 + a_h) * A_h);
        return Y;
    }
}