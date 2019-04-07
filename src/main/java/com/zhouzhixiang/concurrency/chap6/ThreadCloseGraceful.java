package com.zhouzhixiang.concurrency.chap6;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-20 20:02
 */
public class ThreadCloseGraceful {
    static class Worker extends Thread {
        private volatile boolean open = true;
        @Override
        public void run() {
            while (open) {
                // code ......
                try {
                    Thread.sleep(1000);
                    System.out.println(".........");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown (boolean open) {
            this.open = open;
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
        worker.shutdown(false);
    }

}
