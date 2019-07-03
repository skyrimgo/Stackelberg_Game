package com.szy.entity;

/**
 * G_k_gt
 */
public class G_k_gt {
    public static double getG_k_gt(double D, double E, double F, double H, double X, double Y, double Z, double p_e,
            double p_h, double c_k) {
        double G_k_gt = (p_e * (Y * E - Z * D) + p_h * (Y * H - Z * F) + c_k * (Z - Y)) / (Y * Y - X * Z);
        return G_k_gt;
    }
}