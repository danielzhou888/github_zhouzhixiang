package com.scmd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */
public class Adaptee {
    public void op1(){
        System.out.println("Adpatee op1");
        List list = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(200 << 64);
    }
}
