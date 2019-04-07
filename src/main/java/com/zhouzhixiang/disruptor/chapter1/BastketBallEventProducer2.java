package com.zhouzhixiang.disruptor.chapter1;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-01-30 20:19
 */
public class BastketBallEventProducer2 {

    private RingBuffer<BasketBallEvent> ringBuffer;

    public BastketBallEventProducer2(RingBuffer<BasketBallEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(Disruptor<BasketBallEvent> disruptor, ByteBuffer byteBuffer) {
        RingBuffer<BasketBallEvent> ringBuffer = disruptor.getRingBuffer();
        // 获取要通过事件传递的业务数据的同时发布事件
        ringBuffer.publishEvent(new Translator(), (int)byteBuffer.getLong(0));
    }

    static class Translator implements EventTranslatorOneArg<BasketBallEvent, Integer> {

        @Override
        public void translateTo(BasketBallEvent basketBallEvent, long sequence, Integer score) {
            basketBallEvent.setScore(score);
            basketBallEvent.setUsername("周志祥");
        }
    }

}
