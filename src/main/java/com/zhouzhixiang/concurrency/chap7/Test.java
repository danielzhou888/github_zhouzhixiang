package com.zhouzhixiang.concurrency.chap7;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-21 21:02
 */
public class Test {
    public static void main(String[] args) {
        final SynObj sy=new SynObj();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showA();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showB();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showC();
            }
        }).start();
    }
}
