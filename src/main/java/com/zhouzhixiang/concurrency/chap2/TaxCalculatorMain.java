package com.zhouzhixiang.concurrency.chap2;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-16 18:12
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
        // 策略模式
        // 非lambd
//        TaxCalculator t = new TaxCalculator(1000d, 2000d, new SimpleCalculatorStrategy());
        // lambd表达式 + 函数式接口
        TaxCalculator t = new TaxCalculator(1000d, 2000d, (s, b) -> s * 0.3 + b * 0.5);
        double tax = t.calculate();
        System.out.println(tax);
    }
}
