package com.scmd;

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @description: 在Executor中跟踪在关闭之后被取消的任务
 * @author: zhouzhixiang
 * @create: 2018-11-08 20:52
 */
public class TrackingExecutor extends AbstractExecutorService{
    private final ExecutorService exec;
    private final Set<Runnable> tasksCancelledAtShutdown = Collections.synchronizedSet(new HashSet<Runnable>());

    public TrackingExecutor(ExecutorService exec) {
        this.exec = exec;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public List<Runnable> getCancelledTasks(){
        if(!exec.isTerminated())
            throw new IllegalArgumentException("");
        return new ArrayList<>(tasksCancelledAtShutdown);
    }

    @Override
    public void execute(Runnable runnable) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                }finally {
                    if(isShutdown() && Thread.currentThread().isInterrupted())
                        tasksCancelledAtShutdown.add(runnable);
                }
            }
        });
    }
}
