package com.szy.entity;

/**
 * H
 */
public class H {

    public static double getH(double n_he, double n_st_h, double n_hr_s, double n_hr_h) {
        double H = n_he * (n_st_h * n_hr_s + n_hr_h);
        return H;
    }
}