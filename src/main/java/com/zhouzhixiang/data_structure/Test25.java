package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-17 19:26
 */
public class Test25 {

    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /**
     * 复制复杂链表
     * @param head
     * @return
     */
    public static ComplexListNode clone(ComplexListNode head) {
        if(head == null) return null;
        // 先复制结点
        cloneNodes(head);
        // 再链接sibling
        connectNodes(head);
        // 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    /**
     * 复制一个链表，并且将复制后的结点插入到被复制结点的后面，只链接复制结点的next字段
     * @param head 待复制链表的头结点
     */
    private static void cloneNodes(ComplexListNode head) {
        while (head != null) {
            ComplexListNode temp = new ComplexListNode();
            temp.value = head.value;
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
    }

    /**
     * 设置复制结点的sibling字段
     * @param head
     */
    private static void connectNodes(ComplexListNode head) {
        while (head != null) {
            if(head.sibling != null) {
                head.next.sibling = head.sibling.next;
            }
            head = head.next.next;
        }
    }

    /**
     * 将复制结点和被复制结点分开，还原被复制的链表，同时生成监制链表
     * @param head  链表的头结点
     * @return  返回复制链表的头结点
     */
    private static ComplexListNode reconnectNodes(ComplexListNode head) {
        if(head == null) return null;
        ComplexListNode newHead = head.next;
        ComplexListNode move = newHead;
        head.next = newHead.next;
        head = head.next;
        while (head != null) {
            move.next = head.next;
            move = move.next;
            head.next = move.next;
            head = head.next;
        }
        return newHead;
    }

    /**
     * 输出链表信息
     * @param head
     */
    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    /**
     * 判断两个链表是否是同一个链表，不是值相同
     * @param head1
     * @param head2
     * @return
     */
    public static boolean isSame(ComplexListNode head1, ComplexListNode head2) {
        while (head1 != null && head2 != null) {
            if(head1 == head2) {
                head1 = head1.next;
                head2 = head2.next;
            }else {
                return false;
            }
        }
        return head1 == null && head2 == null;
    }
}
