package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description: 输入两颗二叉树A和B，判断B是不是A的子结构
 * @author: zhouzhixiang
 * @create: 2018-11-10 11:59
 */
public class Test17 {

    public static class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int v) {
            this.data = v;
        }
    }

    public static boolean isSubTreeNode(BinaryTreeNode A, BinaryTreeNode B) {
        if (A == null) return false;
        if (B == null) return true;
        boolean result = false;
        if (A.data == B.data){
            result = match(A, B);
        }
        if(result) return true;
        return isSubTreeNode(A.left, B) || isSubTreeNode(A.right, B);
    }

    private static boolean match(BinaryTreeNode A, BinaryTreeNode B) {
        if(A == B) return true;
        if(A == null) return false;
        if(B == null) return true;
        if(A.data == B.data) {
            return match(A.left, B.left) || match(A.right, B.right);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(18);
        root1.left = new BinaryTreeNode(8);
        root1.right = new BinaryTreeNode(29);
        root1.right.left = new BinaryTreeNode(20);
        root1.right.right = new BinaryTreeNode(31);
        root1.left.left = new BinaryTreeNode(5);
        root1.left.left.left = new BinaryTreeNode(4);
        root1.left.left.right = new BinaryTreeNode(6);
        root1.left.right = new BinaryTreeNode(9);
        root1.left.right.right = new BinaryTreeNode(10);
        BinaryTreeNode root2 = new BinaryTreeNode(8);
        root2.left = new BinaryTreeNode(5);
        root2.right = new BinaryTreeNode(9);
        root2.right.right = new BinaryTreeNode(10);
        root2.left.left = new BinaryTreeNode(4);
        root2.left.right = new BinaryTreeNode(6);
        System.out.println(isSubTreeNode(root1, root2));
    }
}
