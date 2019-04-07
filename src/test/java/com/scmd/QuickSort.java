package com.scmd;

/**
 * @program:
 * @description: 快速排序
 * @author: zhouzhixiang
 * @create: 2018-11-01 20:20
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,8,9,4,3,2,5,7,10};
//        quicksort(arr,0,arr.length-1);
//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i]+" ");
//        }
        System.out.println(9/10);
    }

    private static void quicksort(int[] arr, int left, int right) {
        if(arr == null || arr.length == 0) return;
        if(left < right){
            int key = arr[left];
            int low = left;
            int hi = right;
            while (low < hi){
                while (low < hi && arr[low] < key)
                    low++;
                arr[hi] = arr[low];
                while (low < hi && arr[hi] > key)
                    hi--;
                arr[low] = arr[hi];
            }
            arr[low] = key;
            quicksort(arr, left, low - 1);
            quicksort(arr, low + 1, right);
        }
    }
}
