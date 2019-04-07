package com.zhouzhixiang.data_structure;

import java.util.PriorityQueue;

/**
 * Created by Administrator on 2018/10/21.
 */
public class Test {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Test t = new Test();
        Customer customer = t.new Customer();
        Productor productor = t.new Productor();
        productor.start();
        customer.start();
    }

    class Customer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume(){
            while (true){
                synchronized (queue){
                    while (queue.size() == 0){
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                }
            }
        }
    }

    class Productor extends Thread {
        @Override
        public void run() {
            produce();
        }
        private void produce(){
            while (true){
                synchronized (queue){
                    while (queue.size() == queueSize){
                        try {
                            System.out.println("队列满，等待空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("向队列中插入一个元素，队列剩余空间:"+(queueSize-queue.size()));
                }
            }
        }
    }
}
