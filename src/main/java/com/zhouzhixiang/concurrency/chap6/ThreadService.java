package com.zhouzhixiang.concurrency.chap6;

/**
 * @program: scmd-knb-common
 * @description: 暴力停止
 * @author: zhouzhixiang
 * @create: 2019-03-20 20:40
 */
public class ThreadService {
    private Thread excuteThread;
    private volatile boolean finished = false;

    public void excute(Runnable task) {
        excuteThread = new Thread() {
            @Override
            public void run() {
                Thread daemon = new Thread(task);
                daemon.setDaemon(true);
                daemon.start();
                try {
                    daemon.join();
                    finished = true;
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        };
        excuteThread.start();
    }

    public void shutdown(long millis) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) > millis) {
                System.out.println("任务超时，需要结束！");
                excuteThread.interrupt();
                break;
            }
            try {
                excuteThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断！");
                break;
            }
        }
        finished = false;
    }
}
