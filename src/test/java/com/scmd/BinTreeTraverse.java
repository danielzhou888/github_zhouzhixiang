package com.scmd;

import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description: 二叉树
 * @author: zhouzhixiang
 * @create: 2018-10-28 21:17
 */
public class BinTreeTraverse {
    private static int[] array = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;

    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        public Node(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }
    }

    /**
     * @Description: 创建二叉树
     * @Param:
     * @return:
     * @Author: zhouzhixiang
     * @Date: 2018/10/28
     */
    public static void createBinTree() {
        nodeList = new LinkedList<>();
        for(int nodeIndex = 0; nodeIndex < array.length; nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        for(int parentIndex = 0; parentIndex < array.length/2 - 1; parentIndex++){
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex*2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex*2 + 2);
        }
        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex*2 + 1);
        if(array.length % 2 == 1){
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex*2 + 2);

        }
    }

    /**
     * @Description: 先序遍历
     * @Param:
     * @return:
     * @Author: zhouzhixiang
     * @Date: 2018/10/28
     */
    public static void preOrderTraverse(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    /**
     * @Description: 中序遍历
     * @Param:
     * @return:
     * @Author: zhouzhixiang
     * @Date: 2018/10/28
     */
    public static void inOrderTraverse(Node root){
        if(root == null) return;
        inOrderTraverse(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraverse(root.rightChild);
    }

    public static void postOrderTraverse(Node root){
        if(root == null) return;
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        BinTreeTraverse treeTraverse = new BinTreeTraverse();
        treeTraverse.createBinTree();
        Node root = nodeList.get(0);
        System.out.println("先序遍历");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历");
        postOrderTraverse(root);
        System.out.println();
    }
}
