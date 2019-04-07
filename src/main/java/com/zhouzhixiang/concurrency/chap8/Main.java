package com.zhouzhixiang.concurrency.chap8;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-22 18:25
 */
public class Main {

    public static void main(String[] args) {
        ZhouZhiXiang zhouZhiXiang = new ZhouZhiXiang();
        Computer computer = new Computer(zhouZhiXiang);
        zhouZhiXiang.setComputer(computer);

        new Thread() {
            @Override
            public void run() {
                while (true)
                    zhouZhiXiang.playGame();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true)
                    computer.switchGame();
            }
        }.start();
    }
}
