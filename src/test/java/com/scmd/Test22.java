package com.scmd;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-13 12:48
 */
public class Test22 {

    public class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void printBinaryTreeNode(BinaryTreeNode root) {
        if(root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode curNode = root;
        while (!queue.isEmpty()) {
            curNode = queue.remove();
            System.out.print(curNode.data+" ");
            if(curNode.left != null) queue.add(curNode.left);
            if(curNode.right != null) queue.add(curNode.right);
        }
    }
 }
