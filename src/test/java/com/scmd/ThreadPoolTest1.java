package com.scmd;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-13 20:14
 */
public class ThreadPoolTest1 {

    static {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(100));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
