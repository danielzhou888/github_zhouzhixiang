package com.zhouzhixiang.concurrency.chap2;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-16 17:24
 */
public class Bank {

    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("一号窗口");
        TicketWindow t2 = new TicketWindow("二号窗口");
        TicketWindow t3 = new TicketWindow("三号窗口");

        t1.start();
        t2.start();
        t3.start();

    }
}
