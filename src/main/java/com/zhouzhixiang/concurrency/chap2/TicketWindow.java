package com.zhouzhixiang.concurrency.chap2;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-16 17:00
 */
public class TicketWindow extends Thread {

    private static final int MAX = 50;
    private final String name;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (index <= MAX) {
                System.out.println(name+":售出票编号为："+index);
                index++;
            }
        }
    }
}
