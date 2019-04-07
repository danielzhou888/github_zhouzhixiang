package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-14 18:41
 */
public class Test23 {

    public static boolean verifySequenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length <= 0) return false;
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 后序遍历，先左子树，然后根节点，然后右子树
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        // 要处理的数据只有一个，或者没有要处理的数据了
        if(start >= end) return true;
        // 从左向右找第一个大于根节点的元素的位置
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) index++;
        // 执行到此处[start, index-1]的元素都是小于根节点的
        // right用来记录第一个不小于根节点的元素的位置
        int right = index;
        while (index < end - 1 && sequence[index] > sequence[end]) index++;
        // 如果index不等于end-1，说明右子树数据中有不大于根节点的数据，不成立
        if(index != end - 1) return false;
        // 执行到此，目前数据还是合法的
        index = right;
        return verifySequenceOfBST(sequence, start, index - 1) && verifySequenceOfBST(sequence, index, end - 1);
    }
}
