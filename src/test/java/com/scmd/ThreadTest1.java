package com.scmd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-14 20:21
 */
public class ThreadTest1 {
    public void test() {
        ExecutorService exe = Executors.newCachedThreadPool();
        if(exe instanceof ThreadPoolExecutor) ((ThreadPoolExecutor) exe).setCorePoolSize(10);
        else throw new AssertionError();
        ExecutorService executorService = Executors.unconfigurableExecutorService(exe);
    }
}
