package com.zhouzhixiang.concurrency.chap7;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-22 16:29
 */
public class Main {
    public static void main(String[] args) {
        TestObjRunnable runnable = new TestObjRunnable();
        Thread t1 = new Thread(new TestObjRunnable(), "thread1");
        Thread t2 = new Thread(new TestObjRunnable(), "thread2");
        Thread t3 = new Thread(runnable, "thread3");
        Thread t4 = new Thread(runnable, "thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
