package com.szy.entity;

/**
 * F
 */
public class F {

    public static double getF(double n_he, double n_st_h, double n_hr_s, double n_gt_h, double n_hr_h) {
        double F = n_he * (n_st_h * n_hr_s * n_gt_h + n_hr_h * n_gt_h);
        return F;
    }
}