package com.scmd;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Administrator on 2018/10/21.
 */
public class Test2 {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    public static void main(String[] args)  {
        Test2 test = new Test2();
        Productor producer = test.new Productor();
        Customer consumer = test.new Customer();

        producer.start();
        consumer.start();
    }


    class Customer extends Thread {
        @Override
        public void run(){
            super.run();
            consume();
        }
        private void consume(){
            while (true){
                try {
                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Productor extends Thread{
        @Override
        public void run(){
            super.run();
            produce();
        }
        private void produce(){
            while (true){
                try{
                    queue.put(1);
                    System.out.println("向队列中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
