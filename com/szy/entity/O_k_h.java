package com.szy.entity;

/**
 * O_k_h
 */
public class O_k_h {
    public static double getO_k_h(double n_he, double n_hr_h, double n_gt_h, double n_st_h, double n_hr_s,
            double G_k_gt, double G_k_hr) {
        double O_k_h = n_he * (n_hr_h * (n_gt_h * G_k_gt + G_k_hr) + n_st_h * n_hr_s * (n_gt_h * G_k_gt + G_k_hr));
        return O_k_h;
    }
}