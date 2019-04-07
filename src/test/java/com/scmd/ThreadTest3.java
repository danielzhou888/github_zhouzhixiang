package com.scmd;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-14 21:06
 */
public class ThreadTest3 extends ThreadPoolExecutor {
    private final ThreadLocal<Long> starttime = new ThreadLocal<>();
    private final AtomicLong totaltime = new AtomicLong();
    private final AtomicLong tasknum = new AtomicLong();
    private final Logger log = Logger.getLogger("ThreadTest3");

    public ThreadTest3(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        log.fine(String.format("Thread %s: start %s", t, r));
        starttime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long tasktime = System.nanoTime() - starttime.get();
            tasknum.incrementAndGet();
            totaltime.addAndGet(tasktime);
            log.fine(String.format("Thread %s: end %s, time=%dns", t, r, tasktime));
        }finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try{
            log.info(String.format("Terminated: avg time=%dns", totaltime.get() / tasknum.get()));
        }finally {
            super.terminated();
        }
    }
}
