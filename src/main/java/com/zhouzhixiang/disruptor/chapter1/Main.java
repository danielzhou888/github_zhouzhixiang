package com.zhouzhixiang.disruptor.chapter1;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-01-30 20:13
 */
public class Main {
//    public static void main(String[] args) {
//        BasketBallEventFactory factory = new BasketBallEventFactory();
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        int ringBufferSize = 1024 * 1024;
//        Disruptor<BasketBallEvent> disruptor = new Disruptor<BasketBallEvent>(factory, ringBufferSize, executorService, ProducerType.SINGLE, new BlockingWaitStrategy());
//        disruptor.handleEventsWith(new BasketBallEventHandler());
//        disruptor.start();
//
//        RingBuffer<BasketBallEvent> ringBuffer = disruptor.getRingBuffer();
//        BastketBallEventProducer producer = new BastketBallEventProducer(ringBuffer);
//        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
//        for (int i = 0; i < 100; i++) {
//            byteBuffer.putLong(0, i);
//            producer.sendData(byteBuffer);
//        }
//        disruptor.shutdown();
//        executorService.shutdown();
//    }

    public static void main(String[] args) {
        
    }
}
