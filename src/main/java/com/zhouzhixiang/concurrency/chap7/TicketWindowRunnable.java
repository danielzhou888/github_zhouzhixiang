package com.zhouzhixiang.concurrency.chap7;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-21 21:44
 */
public class TicketWindowRunnable implements Runnable {

    private int index;
    private final static int MAX = 500;
    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index > MAX)
                    break;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"的号码是："+(index++));
            }
        }
    }
}
