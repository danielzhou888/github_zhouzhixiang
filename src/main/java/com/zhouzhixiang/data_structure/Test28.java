package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description: 数组中出现次数超过一半的数字
 * @author: zhouzhixiang
 * @create: 2018-11-24 21:16
 */
public class Test28 {

    /**
     * 找出数组中出现次数超过一半的数字
     * @param numbers
     * @return
     */
    public static Integer moreThanHalfNum(int[] numbers) {
        // 进行快速排序
        quickSort(numbers, 0, numbers.length-1);
        // 排序后的中位数即为目标值
        return numbers[numbers.length/2+1];
    }

    /**
     * 快速排序
     * @param numbers
     * @param left
     * @param right
     */
    private static void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            int key = numbers[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && numbers[low] < numbers[key])
                    low++;
                numbers[high] = numbers[low];
                while (low < high && numbers[high] > numbers[key])
                    high--;
                numbers[low] = numbers[high];
            }
            numbers[low] = numbers[key];
            quickSort(numbers, left, low - 1);
            quickSort(numbers, low + 1, right);
        }
    }
}
