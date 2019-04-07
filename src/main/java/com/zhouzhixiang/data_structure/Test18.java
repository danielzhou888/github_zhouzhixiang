package com.zhouzhixiang.data_structure;

import java.util.LinkedList;

/**
 * @program:
 * @description: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author: zhouzhixiang
 * @create: 2018-11-10 14:26
 */
public class Test18 {

    public static class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 递归
     * @param root
     */
    public static void mirror(BinaryTreeNode root) {
        if(root == null) return;
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    /**推荐
     * 非递归--借助于辅助栈
     * @param root
     */
    public static void mirror2(BinaryTreeNode root) {
        if(root == null) return;
        LinkedList<BinaryTreeNode> stack = new LinkedList<>(); // 借助于辅助栈
        BinaryTreeNode current = null;
        BinaryTreeNode temp = null;
        stack.push(root);
        while (!stack.isEmpty()){
            current = stack.pop();
            if(current.left != null || current.right != null){
                temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
            if(current.left != null) stack.push(current.left);
            if(current.right != null) stack.push(current.right);
        }
    }


    /**
     * 中序遍历打印
     * @param root
     */
    public static void printTree(BinaryTreeNode root) {
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.data+" ");
        printTree(root.right);
    }
}
