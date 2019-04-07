package com.scmd;

/**
 * @program:
 * @description:
 * @author: zhouzhixiang
 * @create: 2018-10-28 18:25
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "We Are Happy";
        str = replacef(str,"%20");
        System.out.printf(str);
    }

    private static String replacef(String s, String s1) {
        int originlength = s.length();
        int blackcount = 0;

        for(int i = 0; i < originlength; i++){
            if(s.charAt(i) == ' '){
                blackcount++;
            }
        }

        int newLength = 2*blackcount + originlength;

        char[] temp = new char[newLength];

        for(int i = originlength - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                temp[newLength-1] = '0';
                temp[newLength-2] = '2';
                temp[newLength-3] = '%';
                newLength -= 3;
            }else {
                temp[newLength-1] = s.charAt(i);
                newLength--;
            }
        }

        return String.valueOf(temp);
    }
}
