package com.scmd;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-10-28 14:52
 */
public class Client {
    public static void main(String[] args) {
        MobileComponent  root = new MobileComposite("手机");
        MobileComponent c1 = new MobileComposite("华为");
        MobileComponent c2 = new MobileComposite("苹果");

        MobileComponent s1 = new SpecifyMobile("华为Mate20Pro");
        MobileComponent s2 = new SpecifyMobile("华为Mate20");
        MobileComponent s3 = new SpecifyMobile("iphoneX");
        MobileComponent s4 = new SpecifyMobile("iphoneXR");

        root.addChild(c1);
        root.addChild(c2);

        c1.addChild(s1);
        c1.addChild(s2);
        c2.addChild(s3);
        c2.addChild(s4);

        root.printStruct("");;


    }
}
