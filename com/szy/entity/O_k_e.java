package com.szy.entity;

/**
 * O_e_k
 */
public class O_k_e {
    public static double getO_k_e(double n_gt_e, double n_st_e, double n_hr_s, double n_gt_h, double G_k_gt,
            double G_k_hr) {
        double O_k_e = n_gt_e * G_k_gt + n_st_e * n_hr_s * (n_gt_h * G_k_gt + G_k_hr);
        return O_k_e;
    }

}