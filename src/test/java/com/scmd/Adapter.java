package com.scmd;

/**
 * Created by Administrator on 2018/10/16.
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void op2() {
        System.out.println("Adapter op2");
    }
}
