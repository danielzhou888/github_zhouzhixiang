package com.zhouzhixiang.concurrency.chap2;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-16 18:09
 */
public class TaxCalculator {

    private final double salary;
    private final double bonus;
    private final CalculatorStrategy strategy;

    public TaxCalculator(double salary, double bonus, CalculatorStrategy strategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.strategy = strategy;
    }

    public double calTax() {
        return strategy.calculate(salary, bonus);
    }

    protected double calculate() {
        return this.calTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}
