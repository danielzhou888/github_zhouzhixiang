package com.zhouzhixiang.concurrency.chap7;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-21 21:43
 */
public class BankVersion {

    public static void main(String[] args) {
        final TicketWindowRunnable runnable = new TicketWindowRunnable();
        Thread t1 = new Thread(runnable, "一号窗口");
        Thread t2 = new Thread(runnable, "二号窗口");
        Thread t3 = new Thread(runnable, "三号窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
