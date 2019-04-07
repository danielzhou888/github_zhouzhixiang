package com.zhouzhixiang.concurrency.chap6;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-20 20:02
 */
public class ThreadCloseGraceful2 {
    static class Worker extends Thread {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                // code ......
                try {
                    Thread.sleep(1000);
                    System.out.println(".........");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }

}
