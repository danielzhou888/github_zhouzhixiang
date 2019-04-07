package com.zhouzhixiang.concurrency.chap2;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-16 18:18
 */
public class SimpleCalculatorStrategy implements CalculatorStrategy {

    private static final Double SALARY_RATE = 0.1;
    private static final Double BOUNS_RATE = 0.2;

    @Override
    public double calculate(double salary, double bouns) {
        return SALARY_RATE * salary + BOUNS_RATE * bouns;
    }
}
