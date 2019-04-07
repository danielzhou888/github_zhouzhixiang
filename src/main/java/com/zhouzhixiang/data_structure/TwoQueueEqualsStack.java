package com.zhouzhixiang.data_structure;

import java.util.LinkedList;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-10-29 21:02
 */
public class TwoQueueEqualsStack<T> {

    private LinkedList<T> queue1 = new LinkedList();
    private LinkedList<T> queue2 = new LinkedList();

    public T pop(){
        T re = null;
        if(queue1.size()==0 && queue2.size()==0) return null;
        if(queue1.size()!=0){
            while (queue1.size() > 0){
                re = queue1.pop();
                if(queue1.size() != 0){
                    queue2.add(re);
                }
            }
        }else if(queue2.size()!=0){
            while (queue2.size() > 0){
                re = queue2.pop();
                if(queue2.size() != 0){
                    queue1.add(re);
                }
            }
        }
        return re;
    }

    public void push(T t){
        if(queue1.size()==0 && queue2.size()==0){
            queue1.addLast(t);
        }
        if(queue1.size()!=0){
            queue1.addLast(t);
        }else if(queue2.size()!=0){
            queue2.addLast(t);
        }
    }

    public static void main(String[] args) {
        TwoQueueEqualsStack<Integer> t = new TwoQueueEqualsStack<>();
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);
        t.push(5);

        System.out.println(t.pop());
    }
}
