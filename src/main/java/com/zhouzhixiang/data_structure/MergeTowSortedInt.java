package com.zhouzhixiang.data_structure;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-10-28 18:49
 */
public class MergeTowSortedInt {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,9,11,13,15};
        int[] b = new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26};
        int[] c = new int[a.length+b.length];

        c = merge(a,b,c);
        for (int i = 0; i < c.length; i++){
            System.out.printf(c[i]+"-");
        }
    }

    public static int[] merge(int[] a, int[] b, int[] c){
        if((a==null||a.length==0)&&(b==null||b.length==0)) return new int[0];
        if(a==null||a.length==0) return b;
        if(b==null||b.length==0) return a;

        int aindex = 0;
        int bindex = 0;
        int cindex = 0;

        while(aindex < a.length && bindex < b.length){
            if(a[aindex] < b[bindex])
                c[cindex++] = a[aindex++];
            else
                c[cindex++] = b[bindex++];
        }

        while (aindex < a.length){
            c[cindex++] = a[aindex++];
        }
        while (bindex < b.length){
            c[cindex++] = b[bindex++];
        }

        return c;
    }
}
