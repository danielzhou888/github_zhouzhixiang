package com.scmd;

/**
 * @program:
 * @description: 数值的整数次方
 * @author: zhouzhixiang
 * @create: 2018-10-31 20:48
 */
public class Pow {

    public static void main(String[] args) throws Exception {
        System.out.println(power(2,30));
    }

    public static double power(double base, int exponent) throws Exception {
        if(equal(base,0.0)&&exponent<0) throw new Exception("无意义");
        if(exponent==0) return 1;
        double result = 0.0;
        if(exponent<0) result = powerWithExponent(1.0/base,-exponent);
        else result = powerWithExponent(base,exponent);
        return result;
    }

    private static double powerWithExponent(double base, int exponent) {
        double result = 1.0;
        for(int i = 0; i < exponent; i++){
            result *= base;
        }
        return result;
    }

    private static boolean equal(double base, double v) {
        return Math.abs(base-v)<0.00000001 ? true:false;
    }
}
