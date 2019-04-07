package com.zhouzhixiang.disruptor.chapter1;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-01-30 20:19
 */
public class BastketBallEventProducer {

    private RingBuffer<BasketBallEvent> ringBuffer;

    public BastketBallEventProducer(RingBuffer<BasketBallEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(ByteBuffer byteBuffer) {
        long next = ringBuffer.next();
        try {
            BasketBallEvent basketBallEvent = ringBuffer.get(next);
            basketBallEvent.setScore((int) byteBuffer.getLong(0));
            basketBallEvent.setUsername("周志祥");
        } finally {
            ringBuffer.publish(next);
        }
    }
}
