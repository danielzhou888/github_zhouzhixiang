package com.zhouzhixiang.data_structure;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-17 20:21
 */
public class Test25_2 {
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /**
     * 复杂链表的复制，使用复制链接法（推荐）
     * @param head
     * @return
     */
    public static ComplexListNode clone(ComplexListNode head) {
        if (head == null) return null;
        Map<ComplexListNode, ComplexListNode> map = new HashMap<>();
        ComplexListNode newHead = head;
        ComplexListNode Head = head;
        ComplexListNode newMove = newHead;
        map.put(head, newHead);
        while (head != null) {
            head = head.next;
            newMove.next = head;
            newMove = newMove.next;
            map.put(head, newMove);
        }

        newMove = newHead;
        head = Head;
        while (head != null) {
            if(head.sibling != null){
                newMove.sibling = map.get(head.sibling);
                head = head.next;
                newMove = newMove.next;
            }
        }
        return newHead;
    }

}
