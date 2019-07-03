package com.szy.entity;

/**
 * D
 */
public class D {

    public static double getD(double n_gt_e, double n_st_e, double n_hr_s, double n_gt_h) {
        double D = n_gt_e + n_st_e * n_hr_s * n_gt_h;
        return D;
    }
}