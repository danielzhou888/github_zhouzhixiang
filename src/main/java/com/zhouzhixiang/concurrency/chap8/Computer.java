package com.zhouzhixiang.concurrency.chap8;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-22 18:16
 */
public class Computer {

    private ZhouZhiXiang zhouZhiXiang;

    private final Object lock = new Object();

    public Computer(ZhouZhiXiang zhouZhiXiang) {
        this.zhouZhiXiang = zhouZhiXiang;
    }

    public void open() {
        synchronized (lock) {
            zhouZhiXiang.openComputer();
            System.out.println("Computer opening now ........");
        }
    }

    public void switchTV() {
        synchronized (lock) {
            zhouZhiXiang.switchTV();
            System.out.println("switching to TV ......");
        }
    }


    public void switchGame() {
        synchronized (lock) {
            System.out.println("switching to game ......");
            zhouZhiXiang.switchTV();
        }
    }
}
