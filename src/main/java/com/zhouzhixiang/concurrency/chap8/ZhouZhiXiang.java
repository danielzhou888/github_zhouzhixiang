package com.zhouzhixiang.concurrency.chap8;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-22 18:15
 */
public class ZhouZhiXiang {

    private Computer computer;
    private final Object lock = new Object();

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void watchTV() {
        synchronized (lock) {
            computer.switchTV();
            System.out.println("zhouzhixiang watching the TV.....");
        }
    }

    public void playGame() {
        synchronized (lock) {
            computer.open();
            computer.switchGame();
            System.out.println("zhouzhixiang playing game");
        }
    }


    public void openComputer() {
        synchronized (lock) {
            System.out.println("zhouzhixiang opening the Computer");
        }
    }

    public void switchTV() {
        synchronized (lock) {
            System.out.println("zhouzhixiang switching the TV");
        }
    }
}
