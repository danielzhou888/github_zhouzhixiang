package com.zhouzhixiang.data_structure;//package com.scmd;
//
//import java.util.Stack;
//
///**
// * @program:
// * @description:
// * @author: zhouzhixiang
// * @create: 2018-10-28 19:42
// */
//public class LinkedList<T> {
//
//    private Node head;
//
//    public LinkedList(Node head) {
//        this.head = head;
//    }
//
//    public void display(){
//        Node current = head;
//        while(current!=null){
//            current.display();
//            current = current.next;
//        }
//    }
//    /**
//     * @Description:  从尾到头打印链表，采用递归方式
//     * @Param:
//     * @return:
//     * @Author: zhouzhixiang
//     * @Date: 2018/10/28
//     */
//    public static void reverseNode(Node head) {
//        if(head != null){
//            if(head.next != null){
//                reverseNode(head.next);
//            }
//            System.out.print(head.data+" ");
//        }
//    }
//
//    /**
//     * @Description: 从尾到头打印链表，借用栈
//     * @Param:
//     * @return:
//     * @Author: zhouzhixiang
//     * @Date: 2018/10/28
//     */
//    public static void reverseNodeByStack(Node head){
//        Stack<Node> stack = new Stack<>();
//        while (head != null){
//            stack.push(head);
//            head = head.next;
//        }
//
//        while (!stack.isEmpty()){
//            System.out.print(stack.pop().data);
//        }
//    }
//
//    static class Node {
//        public int data;
//        public Node next;
//
//        public Node(int data) {
//            this.data = data;
//        }
//
//        public void display(){
//            System.out.printf(data+" ");
//        }
//    }
//
//    public static void main(String[] args) {
//        Node head = new Node(100);
//        Node n1 = new Node(99);
//        Node n2 = new Node(98);
//        Node n3 = new Node(97);
//        Node n4 = new Node(96);
//        head.next = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
////        LinkedList list = new LinkedList(head);
////        list.display();
////        reverseNode(head);
//        reverseNodeByStack(head);
//    }
//}
