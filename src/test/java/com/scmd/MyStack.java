package com.scmd;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-10-29 20:27
 */
public class MyStack {
    private long[] arr;
    private int top;

    public MyStack() {
        arr = new long[10];
        top = -1;
    }

    public MyStack(int maxsize){
        arr = new long[maxsize];
        top = -1;
    }

    public void push(int data){
        arr[++top] = data;
    }

    public long pop(){
        return arr[top--];
    }

    public long peek(){
        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == arr.length - 1;
    }
}
