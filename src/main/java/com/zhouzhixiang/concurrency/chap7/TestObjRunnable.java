package com.zhouzhixiang.concurrency.chap7;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-22 16:25
 */
public class TestObjRunnable implements Runnable {
    @Override
    public void run() {
        TestObj obj = new TestObj();
        A();
    }

    /**
     * 修饰非静态方法
     */
    public synchronized static void A() {
        try {
            System.out.println(Thread.currentThread().getName() + "_start:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_end:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
