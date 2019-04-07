package com.scmd;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class OpenUrl_Jianshu {
    public static String str="taskkill /F /IM firefox.exe";
    //这里firefox也可以改为iexplore或者chrome等等,也就是指定打开网页的浏览器，后面这些参数就是网址，
    //实际上有文件来代替更好，主要是本人博客不多也懒得折腾了
    public static String str1="cmd /c start firefox "
            + "https://www.jianshu.com/p/751ded0731d2 "
            + "https://www.jianshu.com/p/110df879442d "
            + "https://www.jianshu.com/p/e850c52dcdf5 "
//            + "https://www.jianshu.com/p/c2fd5e8fc900 "
            + "https://www.jianshu.com/p/9b85a23368a8 "
//            + "https://www.jianshu.com/p/02e17721e92e "
            + "https://www.jianshu.com/p/4ff6cddab05f "
            + "https://www.jianshu.com/p/96aed6cb4a50 "
            + "https://www.jianshu.com/p/e2665228bf44 "
            + "https://www.jianshu.com/p/d9660d8d829b "
            + "https://www.jianshu.com/p/c590753cda8a "
            + "https://www.jianshu.com/p/2a96c11964ad "
            + "https://www.jianshu.com/p/0d781fb44706 "
            + "https://www.jianshu.com/p/976a0e530ecf "
            + "https://www.jianshu.com/p/018ce9f447b6 "
            + "https://www.jianshu.com/p/67ca4aede370 "
            + "https://www.jianshu.com/p/e2665228bf44 "
            + "https://www.jianshu.com/p/d9660d8d829b "
            + "https://www.jianshu.com/p/c590753cda8a "
            + "https://www.jianshu.com/p/2a96c11964ad "
            + "https://www.jianshu.com/p/0d781fb44706 "
            + "https://www.jianshu.com/p/976a0e530ecf "
            + "https://www.jianshu.com/p/018ce9f447b6 "
            + "https://www.jianshu.com/p/67ca4aede370 "
            + "https://www.jianshu.com/p/901abda5f028 "
            + "https://www.jianshu.com/p/2a96c11964ad "
            + "https://www.jianshu.com/p/0d781fb44706 "
            + "https://www.jianshu.com/p/976a0e530ecf "
            + "https://www.jianshu.com/p/018ce9f447b6 "
            + "https://www.jianshu.com/p/67ca4aede370 "
            + "https://www.jianshu.com/p/901abda5f028 "
            + "https://www.jianshu.com/p/8cb984372ad5 "
            + "https://www.jianshu.com/p/5443ff0ccd44 "
            + "https://www.jianshu.com/p/9c8417f1fa03 "
            + "https://www.jianshu.com/p/fb14a94e6558 "
            + "https://www.jianshu.com/p/03ce83353f3d "
            + "https://www.jianshu.com/p/700465d298cb "
            + "https://www.jianshu.com/u/ce0d55ec26f7 "
            + "https://www.jianshu.com/p/8cd5d3a20352 "
            + "https://www.jianshu.com/p/8353cbe6db1c "
            ;

    //我这里把要访问的网址分成了两部分，一次性访问大概二十个左右，浏览器不敢一次打开得太多，怕爆炸
    public static String str2="cmd /c start firefox "
            + "https://www.jianshu.com/p/751ded0731d2 "
            + "https://www.jianshu.com/p/110df879442d "
//            + "https://www.jianshu.com/p/e850c52dcdf5 "
            + "https://www.jianshu.com/p/c2fd5e8fc900 "
            + "https://www.jianshu.com/p/9b85a23368a8 "
//            + "https://www.jianshu.com/p/02e17721e92e "
            + "https://www.jianshu.com/p/4ff6cddab05f "
            + "https://www.jianshu.com/p/e2665228bf44 "
            + "https://www.jianshu.com/p/d9660d8d829b "
            + "https://www.jianshu.com/p/c590753cda8a "
            + "https://www.jianshu.com/p/2a96c11964ad "
            + "https://www.jianshu.com/p/0d781fb44706 "
            + "https://www.jianshu.com/p/976a0e530ecf "
            + "https://www.jianshu.com/p/018ce9f447b6 "
            + "https://www.jianshu.com/p/67ca4aede370 "
            + "https://www.jianshu.com/p/e2665228bf44 "
            + "https://www.jianshu.com/p/d9660d8d829b "
            + "https://www.jianshu.com/p/c590753cda8a "
            + "https://www.jianshu.com/p/2a96c11964ad "
            + "https://www.jianshu.com/p/0d781fb44706 "
            + "https://www.jianshu.com/p/976a0e530ecf "
            + "https://www.jianshu.com/p/018ce9f447b6 "
            + "https://www.jianshu.com/p/67ca4aede370 "
            + "https://www.jianshu.com/p/901abda5f028 "
            + "https://www.jianshu.com/p/8cb984372ad5 "
            + "https://www.jianshu.com/p/5443ff0ccd44 "
            + "https://www.jianshu.com/p/9c8417f1fa03 "
            + "https://www.jianshu.com/p/fb14a94e6558 "
            + "https://www.jianshu.com/p/03ce83353f3d "
            + "https://www.jianshu.com/p/700465d298cb "
            ;

    public static ArrayList<String> strList=new ArrayList<String>();


    public OpenUrl_Jianshu(){
        strList.add(str1);
        strList.add(str2);
    }

    public static void main(String args[]) {
        // defaultBrowserOpenUrl();
        OpenUrl_Jianshu openUrl=new OpenUrl_Jianshu();
        while(true){
            int i = 0;
            String strUrl = "";
            while (i < 2) {
                strUrl = strList.get(i);
                openFirefoxBrowser(strUrl, str);
                //每关闭一次浏览器，等待大概30s再重启，太过频繁浏览器会爆炸
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                i++;
            }
            //遍历一次睡一个小时，一天可以跑个二十二二十三次左右
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //使用指定的浏览器打开
    public static void openFirefoxBrowser(String start,String stop) {
        // 启用cmd运行firefox的方式来打开网址。
        try {
            Runtime.getRuntime().exec(start);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Runtime.getRuntime().exec(stop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用操作系统默认的浏览器打开
    private static void defaultBrowserOpenUrl() {
        // ...
        try {
            Desktop.getDesktop().browse(new URI("http://blog.csdn.net/u012062455/article/details/52369288"));
        } catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 网址被屏蔽了，手动加网址试一下。
    }

}
