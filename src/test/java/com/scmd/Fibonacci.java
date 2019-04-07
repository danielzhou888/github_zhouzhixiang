package com.scmd;

import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-10-31 19:38
 */
public class Fibonacci {

    public static void main(String[] args) throws Exception {
        getStepMain(30);
        getStepMain2(30);
    }

    /** 
     * @Description: 递归获取
     * @Param:  
     * @return:  
     * @Author: zhouzhixiang
     * @Date: 2018/10/31 
     */
    public static void getStepMain(int n) throws Exception {
        System.out.println("递归。。。。。。。。。。。。。");
        //开始时的纳秒
        long start = System.nanoTime();
        long step = getStep1(n);
        //花费的纳秒数
        long during = System.nanoTime() - start;
        System.out.println(during);
        //将纳秒转换为毫秒
        long seconds = TimeUnit.MILLISECONDS.convert(during, TimeUnit.NANOSECONDS);
        System.out.println(step);
        System.out.println("当n为" + n + "时，花费时间为" + seconds + "毫秒");
    }

    /**
     * @Description: 递归获取
     * f1=1,f2=2,f3=f1+f2......fn=fn-1+fn-2
     * @Param:
     * @return:
     * @Author: zhouzhixiang
     * @Date: 2018/10/31
     */
    public static long getStep1(int n) throws Exception {
        if(n<=0) throw new Exception("台阶数量不符合要求");
        if(n==1) return 1;
        if(n==2) return 2;
        return getStep1(n-1)+getStep1(n-2);
    }

    /**
     * @Description: 非递归获取
     * @Param:
     * @return:
     * @Author: zhouzhixiang
     * @Date: 2018/10/31
     */
    public static void getStepMain2(int n) throws Exception {
        System.out.println("非递归。。。。。。。。。。。。。");
        //开始时的纳秒
        long start = System.nanoTime();
        long step = getStep2(n);
        //花费的纳秒数
        long during = System.nanoTime() - start;
        System.out.println(during);
        //将纳秒转换为毫秒
        long seconds = TimeUnit.MILLISECONDS.convert(during, TimeUnit.NANOSECONDS);
        System.out.println(step);
        System.out.println("当n为" + n + "时，花费时间为" + seconds + "毫秒");
    }

    /**
     * @Description: 递归获取
     * f1=1,f2=2,f3=f1+f2......fn=fn-1+fn-2
     * @Param:
     * @return:
     * @Author: zhouzhixiang
     * @Date: 2018/10/31
     */
    public static long getStep2(int n) throws Exception {
        if(n<=0) throw new Exception("台阶数量不符合要求");
        if(n==1) return 1;
        if(n==2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 3; i < n; i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

}
