package com.szy.entity;

/**
 * Tau_e
 */
public class Tau_h {

    public static double getTau_h(double lambda_h, double miu_h, int i) {
        double Tau_h = 1.0 / (lambda_h + miu_h * (i )) ;
        return Tau_h;
    }
}