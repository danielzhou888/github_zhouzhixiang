package com.zhouzhixiang.disruptor.chapter1;

import com.lmax.disruptor.EventFactory;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-01-30 20:05
 */
public class BasketBallEventFactory implements EventFactory<BasketBallEvent> {

    @Override
    public BasketBallEvent newInstance() {
        return new BasketBallEvent();
    }
}
