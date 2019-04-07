package com.zhouzhixiang.concurrency.chap7;

import java.util.stream.IntStream;

/**
 * @program: scmd-knb-common
 * @description: synchronized的同步代码块以及同步方法之间的区别和关系
 * @author: zhouzhixiang
 * @create: 2019-03-21 20:29
 */
public class SynchronizedTest2 {

    /**
     * 银行
     */
    class Bank {
        private int account = 100;

        public int getAccount() {
            return account;
        }
        /**
         * 用同步方法实现
         * @param money
         */
        public synchronized void save(int money) {
            account += money;
        }

        public void save2(int money) {
            synchronized(this) {
                account += money;
            }
        }
    }

    class MyThread implements Runnable {
        private Bank bank;
        @Override
        public void run() {
            IntStream.range(0, 10).forEach(i -> {
                bank.save(10);
                System.out.println(i + "账户余额为：" + bank.getAccount());
            });
        }
    }

    public void saveThread() {

    }
}
