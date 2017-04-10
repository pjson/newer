package com.newer.text;

import java.awt.*;
import java.lang.reflect.Parameter;
import java.util.regex.Pattern;

import static java.awt.SystemColor.text;

/**
 * Created by json on 2017/3/1.
 */
public class TextDemo {
    public static void main(String[] args) {
//        String str="c.java.html|css|js-php--pythan";
//        String [] array=str.split("[,\\|-]");
//        for (String s1 : array) {
//            System.out.println(s1);
//        }
//
//
//        Pattern pattern=Pattern.compile("\\d{3,4}-\\d{7,8}");
//        System.out.println("---------------------");
//        System.out.println(pattern.matcher("ddd-13333333").matches());
//        System.out.println(pattern.matcher("8934-12345678").matches());
//        System.out.println(pattern.matcher("123-3323333").matches());
//        System.out.println(pattern.matcher("1234-123456789").matches());


//        String[]ws=str.replaceAll("\\w&&[^\\s]]").split("");
        String str1="we are family,today is big day.";
        String []ws =str1.replaceAll("[\\pP\\p{Punct}]", "").split("\\pP+|\\pZ+|\\pS+|\\pN+|\\pC+|\\p{Zs}+");
        for (String w : ws) {
            System.out.println(w);
        }
        isPhoneNumber(text);
//        replaceChar(str);
    }

    /**
     * 统计文件中单词出现的频率
     * @param str
     */
    private static void replaceChar(String str) {
    }

    private static void isPhoneNumber(SystemColor text) {

    }


}
