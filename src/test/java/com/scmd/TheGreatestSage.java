//package com.scmd;
//
//import com.scmd.common.HttpUtil;
//
//import java.io.IOException;
//import java.io.Serializable;
//
///**
// * Created by Administrator on 2018/10/15.
// */
//public class TheGreatestSage implements Serializable{
//    private Monkey monkey = new Monkey();
//
//    public void change() throws IOException, ClassNotFoundException {
////        Monkey copymonkey = (Monkey) monkey.clone();
//        Monkey copymonkey = (Monkey) monkey.deepClone();
//        System.out.println("大圣本尊的生日是：" + monkey.getBirthDate());
//        System.out.println("克隆的大圣的生日是：" + monkey.getBirthDate());
//        System.out.println("大圣本尊跟克隆的大圣是否为同一个对象 " + (monkey == copymonkey));
//        System.out.println("大圣本尊持有的金箍棒 跟 克隆的大圣持有的金箍棒是否为同一个对象？ " + (monkey.getStaff() == copymonkey.getStaff()));
//    }
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
////        for(int i = 0; i < 100; i++){
//
//            String s = HttpUtil.doGet("https://blog.csdn.net/danielzhou888/article/details/82932150");
//            System.out.println(s);
////        }
//    }
//}
