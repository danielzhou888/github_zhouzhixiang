package com.zhouzhixiang.concurrency.chap2;

@FunctionalInterface
public interface CalculatorStrategy {
    double calculate(double salary, double bouns);
}
