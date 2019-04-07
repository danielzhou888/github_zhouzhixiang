package com.zhouzhixiang.concurrency.chap7;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-21 13:07
 */
public class SynchronizedTest {
    private final static Object LOCK = new Object();
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                synchronized (LOCK) {
                    Thread.sleep(200_000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(runnable,"synchronized_1");
        Thread t2 = new Thread(runnable,"synchronized_2");
        Thread t3 = new Thread(runnable,"synchronized_3");

        t1.start();
        t2.start();
        t3.start();
    }
}
