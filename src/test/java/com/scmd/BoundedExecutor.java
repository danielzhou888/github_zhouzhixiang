package com.scmd;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @program:
 * @description: 使用Semaphore控制线程池任务提交速率
 * @author: zhouzhixiang
 * @create: 2018-11-13 20:48
 */
@ThreadSafe
public class BoundedExecutor {
    private final ExecutorService executor;
    private final Semaphore semaphore;

    public BoundedExecutor(ExecutorService executor, int bound) {
        this.executor = executor;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) {
        try {
            semaphore.acquire();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        } catch (InterruptedException e) {
            semaphore.release();
        }
    }

    public void stop(){
        this.executor.shutdown();
    }

    static class MyThread extends Thread {
        public String name;
        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread-"+name+" is running....");
            try {
                Thread.sleep(new Random().nextInt(10000));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,2,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(5));
        BoundedExecutor executor = new BoundedExecutor(executorService, 5);
        for (int i = 0; i < 100; i++) {
            executor.submitTask(new MyThread(""+i));
        }
        executor.stop();
    }
}
