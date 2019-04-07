package com.scmd;

import java.util.Stack;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-10-29 20:48
 */
public class TwoStackToQueue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendToTail(T t){
        stack1.push(t);
    }

    public T deleteFromHead(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            if(!stack2.isEmpty()){
                return stack2.pop();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoStackToQueue<Integer> t = new TwoStackToQueue();
        t.appendToTail(1);
        t.appendToTail(2);
        t.appendToTail(3);
        t.appendToTail(4);
        t.appendToTail(5);

        System.out.println(t.deleteFromHead());
    }
}
