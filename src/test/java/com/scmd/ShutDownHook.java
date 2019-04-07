package com.scmd;

/**
 * @program:
 * @description: 通过注册一个关闭钩子来停止日志服务
 * @author: zhouzhixiang
 * @create: 2018-11-10 16:42
 */
public class ShutDownHook {

    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
            }

        });
    }

}
