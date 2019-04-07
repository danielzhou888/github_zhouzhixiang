package com.scmd;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @program:
 * @description: 私有Executor，在多台主机上并行地检查新邮件，只执行一次任务
 * @author: zhouzhixiang
 * @create: 2018-11-08 19:45
 */
public class PrivateExecutor {

    public AtomicBoolean CheckMail(Set<String> hosts, long timeout, TimeUnit unit) throws InterruptedException {
        ExecutorService exe = Executors.newCachedThreadPool();
        final AtomicBoolean hasNewMail = new AtomicBoolean(false);
        try{
            for(final String host : hosts){
                exe.execute(new Runnable() {
                    @Override
                    public void run() {
                        if(checkMail(host)){
                            hasNewMail.set(true);
                        }
                    }

                });
            }
        }finally {
            exe.shutdown();
            exe.awaitTermination(timeout,unit);
        }
        return hasNewMail;
    }

    private boolean checkMail(String host) {
        return true;
    }
}
