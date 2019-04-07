package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description: 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的，并返回合并后的头结点。
 * @author: zhouzhixiang
 * @create: 2018-11-09 21:40
 */
public class Test16 {

    public static class ListNode {
        int data;
        ListNode next;
    }

    /**
     * 推荐使用此方法
     * @param head1  第一个有序列表
     * @param head2  第二个有序列表
     * @return
     */
    public static ListNode merge1(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode root = new ListNode();
        ListNode move = root;
        while (head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                move.next = head1;
                head1 = head1.next;
            }else {
                root = head2;
                root.next = head2;
                head2 = head2.next;
            }
            move = move.next;
        }
        // 未空链表元素处理
        if(head1.next!=null) move.next = head1;
        if(head2.next!=null) move.next = head2;
        // 返回头结点
        return root.next;
    }

    /**
     * 递归
     * 不推荐
     * 递归调用的时候会有方法入栈，需要更多的内存
     * @param head1  第一个有序列表
     * @param head2  第二个有序列表
     * @return
     */
    public static ListNode merge2(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode root = head1;
        if(head1.data < head2.data) {
            root.next = merge2(head1.next, head2);
        }else {
            root = head2;
            root.next = merge2(head1, head2.next);
        }
        return root;
    }
}
