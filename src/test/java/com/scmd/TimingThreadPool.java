package com.scmd;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @program:
 * @description: 具备日志和计时等功能的线程池
 * @author: zhouzhixiang
 * @create: 2018-11-14 20:40
 */
public class TimingThreadPool extends ThreadPoolExecutor{
    private final ThreadLocal<Long> starttime = new ThreadLocal<>();
    private final AtomicLong numtask = new AtomicLong();
    private final AtomicLong totaltime = new AtomicLong();
    private final Logger logger = Logger.getLogger("TimingThreadPool");

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        logger.fine(String.format("Thread %s: start %s", t, r));
        starttime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endtime = System.nanoTime() - starttime.get();
            totaltime.addAndGet(endtime);
            numtask.incrementAndGet();
            logger.fine(String.format("Thread %s: end %s, time=%dns", t, r, totaltime));
        }finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try{
            logger.info(String.format("Terminated: avg time=%dns", totaltime.get() / numtask.get()));
        }finally {
            super.terminated();
        }
    }
}
