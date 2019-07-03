package com.szy;

import java.util.Arrays;
import java.util.Random;

import com.szy.entity.A_e;
import com.szy.entity.A_h;
import com.szy.entity.D;
import com.szy.entity.D_e;
import com.szy.entity.D_h;
import com.szy.entity.E;
import com.szy.entity.F;
import com.szy.entity.G_k_gt;
import com.szy.entity.G_k_hr;
import com.szy.entity.H;
import com.szy.entity.O_k_e;
import com.szy.entity.O_k_h;
import com.szy.entity.Tau_e;
import com.szy.entity.Tau_h;
import com.szy.entity.X;
import com.szy.entity.Y;
import com.szy.entity.Z;

/**
 * Main
 */
public class Main {

    static int i = 0;// 初始迭代次数
    static double[] c_k_array = { 18.5, 19.0, 19.5, 20 };// 可变成本系数
    static double n_gt_e = 0.35; // 燃气轮机的电效率
    static double n_gt_h = 0.5; // 燃气轮机的热效率
    static double n_hr_s = 0.1; // 余热锅炉生产蒸汽的效率
    static double n_hr_h = 0.7; // 余热锅炉生产热水的效率
    static double n_st_e = 0.42; // 蒸汽轮机的电效率
    static double n_st_h = 0.38; // 蒸汽轮机的热效率
    static double n_he = 0.8;// 热转换机的热转换效率
    static double a_e = 0.04;// 电能传输过程中的网络损耗参数
    static double a_h = 0.06;// 热能传输过程中的网络损耗参数
    static double lambda_e = 0.05;// 速度调整常数
    static double miu_e = 4;
    static double lambda_h = 0.04;
    static double miu_h = 4;
    static double theta = 1e-6;// 收敛精度
    static double[] u_e_array = { 7, 7, 7, 7, 7 };// 用户对消耗电能的偏好常系数
    static double[] v_e_array = { 55, 55, 55, 55, 55 };
    static double[] u_h_array = { 7, 7, 7, 7, 7 };// 用户对消耗热能的偏好常系数
    static double[] v_h_array = { 60, 60, 60, 60, 60 };
    static double[] d_e_array = new double[5];// 用户的电需求量
    static double[] d_h_array = new double[5];// 用户的热需求量
    static double[] O_k_e_array = new double[4];// DES输出的电量
    static double getO_k_e = 0;
    static double[] O_k_h_array = new double[4];// DES输出的热量
    static double getO_k_h = 0;
    static double delta_e = 0;// 单位电价增量
    static double delta_h = 0;// 单位热价增量
    static double getG_k_gt = 0;// 输入燃气轮机的天然气量
    static double getG_k_hr = 0;// 输入余热锅炉的天然气量
    static double getD = 0;
    static double getE = 0;
    static double getF = 0;
    static double getH = 0;
    static double getX = 0;
    static double getY = 0;
    static double getZ = 0;
    static double getA_e = 0;
    static double getA_h = 0;
    static double getTau_e = 0;// 动态速度调整参数
    static double getTau_h = 0;
    static double getD_e = 0;
    static double getD_h = 0;
    static Random r = new Random();// 随机初始化p_e,p_h
    static double p_e = r.nextDouble() * 100;// 单位电价
    static double p_h = r.nextDouble() * 100;// 单位热价

    public static void main(String[] args) {
        // 对于4个DES，for
        do {
            System.out.println("第" + i + "次博弈结果：\n" + "单位电价：" + p_e + "\t单位热价：" + p_h);
            for (int k = 0; k < 4; k++) {
                getD = D.getD(n_gt_e, n_st_e, n_hr_s, n_gt_h);
                getE = E.getE(n_st_e, n_hr_s);
                getF = F.getF(n_he, n_st_h, n_hr_s, n_gt_h, n_hr_h);
                getH = H.getH(n_he, n_st_h, n_hr_s, n_hr_h);

                getA_e = A_e.getA_e(u_e_array);
                getA_h = A_h.getA_h(u_h_array);
                getX = X.getX(getD, getF, a_e, a_h, getA_e, getA_h);
                getY = Y.getY(getD, getE, getF, getH, a_e, a_h, getA_e, getA_h);
                getZ = Z.getZ(getE, getH, a_e, a_h, getA_e, getA_h);
                getG_k_gt = G_k_gt.getG_k_gt(getD, getE, getF, getH, getX, getY, getZ, p_e, p_h, c_k_array[k]);
                getG_k_hr = G_k_hr.getG_k_hr(getD, getE, getF, getH, getX, getY, getZ, p_e, p_h, c_k_array[k]);
                getO_k_e = O_k_e.getO_k_e(n_gt_e, n_st_e, n_hr_s, n_gt_h, getG_k_gt, getG_k_hr);
                O_k_e_array[k] = getO_k_e;
                getO_k_h = O_k_h.getO_k_h(n_he, n_hr_h, n_gt_h, n_st_h, n_hr_s, getG_k_gt, getG_k_hr);
                O_k_h_array[k] = getO_k_h;
            }
            // 对于5个EU,for
            for (int n = 0; n < 5; n++) {
                getD_e = D_e.getD_e(v_e_array[n], u_e_array[n], p_e);
                d_e_array[n] = getD_e;
                getD_h = D_h.ghtD_h(v_h_array[n], u_h_array[n], p_h);
                d_h_array[n] = getD_h;
            }
            // 更新p_e,p_h
            getTau_e = Tau_e.getTau_e(lambda_e, miu_e, i);
            getTau_h = Tau_h.getTau_h(lambda_h, miu_h, i);

            delta_e = getTau_e * ((1.0 + a_e) * Arrays.stream(d_e_array).sum() - Arrays.stream(O_k_e_array).sum());
            delta_h = getTau_h * ((1.0 + a_h) * Arrays.stream(d_h_array).sum() - Arrays.stream(O_k_h_array).sum());
            p_e += delta_e;
            p_h += delta_h;
            i++;
        } while ((Math.abs(delta_e) > theta || Math.abs(delta_h) > theta));
        System.out.println("------\n纳什平衡：\n" + "单位电价：" + p_e + "\t单位热价：" + p_h);
    }
}