package com.zhouzhixiang.java8;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-02-14 13:51
 */
public class Test1 {

    public static void main(String[] args) {
        First first = () -> {};
        System.out.println(first.getClass().getInterfaces()[0]);
        Second second = () -> {};
        System.out.println(second.getClass().getInterfaces()[0]);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        }).start();

        new Thread(() -> System.out.println("test")).start();
    }


    @FunctionalInterface
    interface First {
        void first();
    }

    @FunctionalInterface
    interface Second {
        void second();
    }
}
