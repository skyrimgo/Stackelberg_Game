package com.szy.entity;

/**
 * Tau_e
 */
public class Tau_e {

    public static double getTau_e(double lambda_e, double miu_e, int i) {
        double Tau_e = 1.0 / (lambda_e + miu_e * (i ));
        return Tau_e;
    }
}