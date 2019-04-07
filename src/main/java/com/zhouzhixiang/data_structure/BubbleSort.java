package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description: 冒泡排序
 * @author: zhouzhixiang
 * @create: 2018-11-02 20:57
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,4,3,2,8,9,1,10,6,7};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+"-");
        }
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
