package com.zhouzhixiang.concurrency.chap7;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-21 21:02
 */
public class SynObj {
    public synchronized void showA(){
        System.out.println("showA..");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showB(){
        synchronized (this) {
            System.out.println("showB..");
        }
    }

    public void showC(){
        String s="1";
        synchronized (s) {
            System.out.println("showC..");
        }
    }




    public void A() {
        synchronized (new TicketWindowRunnable()) {


        }
    }


}
