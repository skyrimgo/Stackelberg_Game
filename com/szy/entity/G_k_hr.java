package com.szy.entity;

/**
 * G_k_hr
 */
public class G_k_hr {

    public static double getG_k_hr(double D, double E, double F, double H, double X, double Y, double Z, double p_e,
            double p_h, double c_k) {
        double G_k_hr = (p_e * (Y * D - X * E) + p_h * (Y * F - X*H) + c_k * (X - Y)) / (Y * Y - X * Z);
        return G_k_hr;
    }
}