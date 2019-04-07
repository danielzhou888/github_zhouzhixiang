package com.scmd;

/**
 * @program:
 * @description: 二分查找
 * @author: zhouzhixiang
 * @create: 2018-11-06 20:08
 */
public class BinSearch {

    /**
     * 二分查找普通实现
     * @param array
     * @param key
     * @return
     */
    public static int binSearch(int array[], int key){
        int mid;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            mid = (end - start)/2 + start;
            if (array[mid] > key){
                end = mid - 1;
            } else if(array[mid] < key){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     * @param array
     * @param key
     * @return
     */
    public static int binSearch2(int array[], int key, int start, int end){
        int mid = (start + end) / 2;
        while (start < end) {
            if(array[mid] > key) return binSearch2(array,key,start,mid-1);
            else if (array[mid] < key) return binSearch2(array,key,mid+1,end);
            else return mid;
        }
        return -1;
    }

}
