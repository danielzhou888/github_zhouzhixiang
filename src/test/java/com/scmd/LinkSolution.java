package com.scmd;

/**
 * @program:
 * @description: java 输入一个链表，输出该链表中倒数第k个结点。
 * @author: zhouzhixiang
 * @create: 2018-11-01 21:13
 */
public class LinkSolution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode c0 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);

        head.next = c0;
        c0.next = c1;
        c1.next = c2;
        c2.next = c3;

        ListNode listNode = printLastKListNode(1, head);
        System.out.println(listNode.data);
    }

    static class ListNode {
        ListNode next;
        int data;
        ListNode(int data){
            this.data = data;
        }
    }

    public static ListNode printLastKListNode(int k, ListNode head){
        if(head == null) return null;
        int num = 0;
        int len = 0;
        ListNode curNode = head;
        ListNode thNode = head;
        while (curNode != null){
            curNode = curNode.next;
            num++;
        }
        if(k > num) return null;
        while (thNode != null){
            if(num - len == k) break;
            thNode = thNode.next;
            len++;
        }
        return thNode;
    }
}
