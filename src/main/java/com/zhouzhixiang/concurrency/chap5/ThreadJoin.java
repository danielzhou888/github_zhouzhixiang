package com.zhouzhixiang.concurrency.chap5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-03-21 20:42
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        Thread t2 = new Thread(() -> {
            IntStream.rangeClosed(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Optional.of("All Task is Done").ifPresent(System.out::println);

        IntStream.rangeClosed(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}
