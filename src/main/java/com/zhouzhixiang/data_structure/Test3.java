package com.zhouzhixiang.data_structure;

import java.util.Vector;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-11-02 19:58
 */
public class Test3 {

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(3);
        v.add(5);
        v.add(2);
        v.add(4);
        v.add(9);
        v.add(6);
        v.add(7);
        v.add(8);

        quickSort(v,0,v.size()-1);
        v.forEach(c  -> {
                System.out.print(c);
        });


    }

    private static void quickSort(Vector<Integer> v, int left, int right) {
        if(v == null ) return;
        if(left < right){
            int key = v.get(left);
            int low = left;
            int hi = right;
            while (low < hi){
                while (low < hi && v.get(hi) > key)
                    hi--;
                v.set(low,v.get(hi));
                while (low < hi && v.get(low) < key)
                    low++;
                v.set(hi,v.get(low));
            }
            v.set(low, key);
            quickSort(v, left, low - 1);
            quickSort(v, low + 1, right);
        }
    }
}
