package com.zhouzhixiang.data_structure;

import java.util.Stack;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-12 23:36
 */
public class Test21 {

    /**
     * 输入两个整数序列，第一个表示栈的压入书序，第二个表示栈的弹出顺序
     * @param push
     * @param pop
     * @return
     */
    public static boolean isPopOrder(int[] push, int[] pop) {
        if(push == null || pop == null || push.length == 0 || pop.length == 0 || push.length != pop.length) return false;
        int pushindex = 0;
        int popindex = 0;
        // 栈-进行压栈和出栈操作
        Stack<Integer> stack = new Stack<>();
        // 如果出栈未结束
        while(popindex < pop.length) {
            // 如果栈未压满，或者栈不为空，当前处理元素不为栈顶元素
            while (pushindex < push.length && (stack.isEmpty() || stack.peek() != pop[popindex])) {
                // 压栈
                stack.push(push[pushindex]);
                pushindex++;
            }
            // 如果当前处理元素为栈顶元素
            if(stack.peek() == pop[popindex]) {
                // 出栈，比较下一个元素
                stack.pop();
                popindex++;
            }else {
                return false;
            }
        }
        return true;
    }
}
