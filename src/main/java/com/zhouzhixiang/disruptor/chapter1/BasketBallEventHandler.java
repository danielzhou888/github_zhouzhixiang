package com.zhouzhixiang.disruptor.chapter1;

import com.lmax.disruptor.EventHandler;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-01-30 20:09
 */
public class BasketBallEventHandler implements EventHandler<BasketBallEvent> {
    @Override
    public void onEvent(BasketBallEvent basketBallEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("篮球运动员："+basketBallEvent.getUsername()+"投进"+basketBallEvent.getScore()+"分");
    }
}
