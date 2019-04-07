package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description: 给定链表的头指针和一个结点指针，在O(1)时间删除该结点。
 * @author: zhouzhixiang
 * @create: 2018-10-31 21:15
 */
public class DeleteLinkedNode {

    class ListNode{
        ListNode next = null;
        int data;
    }

    public void deleteNode(ListNode head, ListNode delNode){
        if(head==null || delNode==null) return;
        if(delNode == head) head = head.next;
        if(delNode.next!=null){
            delNode.data = delNode.next.data;
            delNode.next = delNode.next.next;
        }else {
            ListNode tempNode = head;
            while (tempNode.next.next==null){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
        }
    }
}
