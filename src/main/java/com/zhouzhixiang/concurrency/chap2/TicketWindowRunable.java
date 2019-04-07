package com.zhouzhixiang.concurrency.chap2;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-16 17:42
 */
public class TicketWindowRunable implements Runnable {

    private static final int MAX = 50;
    private static String name;
    private static int index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread()+"售出票编号："+index++);
        }
    }
}
