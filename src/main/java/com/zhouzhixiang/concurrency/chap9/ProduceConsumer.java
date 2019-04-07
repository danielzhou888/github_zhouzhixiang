package com.zhouzhixiang.concurrency.chap9;

import java.util.stream.Stream;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-25 21:48
 */
public class ProduceConsumer {

    private int i = 0;
    private static final Object LOCK = new Object();
    private volatile boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            while (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"：生产了"+(++i)+"个商品");
            LOCK.notifyAll();
            isProduced = true;
        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":消费了"+(i)+"个商品");
            LOCK.notifyAll();
            isProduced = false;
        }
    }

    public static void main(String[] args) {
        ProduceConsumer pc = new ProduceConsumer();
        Stream.of("P1", "P2").forEach(n -> {
            new Thread(n) {
                @Override
                public void run() {
                    while (true) {
                        pc.produce();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });

        Stream.of("C1", "C2", "C3").forEach(n -> {
            new Thread(n) {
                @Override
                public void run() {
                    while (true) {
                        pc.consume();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });
    }
}

