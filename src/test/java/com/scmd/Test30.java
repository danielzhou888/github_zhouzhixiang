package com.scmd;

/**
 * @program:  连续子数组的最大和
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-12-01 21:45
 */
public class Test30 {

    /**
     * 题目：      输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
     *            求所有子数组的和的最大值。要求时间复杂度为O(n)。
     * @param arr 输入数组
     * @return    子数组最大和
     */
    public static int findGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length < 1)
            throw new IllegalArgumentException("Array must contain an element");
        // 记录最大的子数组和, 开始时是最小的整数
        int max = Integer.MIN_VALUE;
        // 当前的和
        int curMax = 0;
        for (int i : arr) {
            // 如果当前和小于等于0，重新设置当前和
            if (curMax <= 0)
                curMax = i;
            else
            // 如果当前和大于0，就累加当前和
                curMax += i;
            // 更新最大子数组和
            if (max < curMax)
                max = curMax;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};
        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
    }

}
