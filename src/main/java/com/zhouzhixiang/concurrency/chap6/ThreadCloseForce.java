package com.zhouzhixiang.concurrency.chap6;

/**
 * @program: scmd-knb-common
 * @description: 暴力
 * @author: zhouzhixiang
 * @create: 2019-03-20 20:38
 */
public class ThreadCloseForce {

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long startTime = System.currentTimeMillis();
        service.excute(() -> {
            // load a very heavy resouce
//            while (true) {
//
//            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown(10000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
