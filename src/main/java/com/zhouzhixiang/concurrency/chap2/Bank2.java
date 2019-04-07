package com.zhouzhixiang.concurrency.chap2;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-16 17:24
 */
public class Bank2 {

    private static final int MAX = 50;

    public static void main(String[] args) {
        TicketWindowRunable runable = new TicketWindowRunable();

        final Runnable runnable = () -> {
            int index = 1;
            while (index <= MAX) {
                System.out.println(Thread.currentThread()+"售出票编号："+index++);
            }
        };

        Thread t1 = new Thread(runable, "一号窗口");
        Thread t2 = new Thread(runable, "二号窗口");
        Thread t3 = new Thread(runable, "三号窗口");

        t1.start();
        t2.start();
        t3.start();

    }
}
