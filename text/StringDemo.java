package com.newer.text;

/**
 * Created by json on 2017/3/1.
 */
public class StringDemo {
    public static void main(String[] args) {
        String str="hello java";//web替换java
        str=str.replaceAll("java","web");//String本身是不可变的，底层是数组
        System.out.println(str);

        int i=111;
        String str1=String.valueOf(i+"dss");
        System.out.println(str1);

        String s="hello";
        int t=100000;
        long l=System.currentTimeMillis();
        //考虑多线程
        StringBuffer buffer=new StringBuffer("hello");
        for (int a= 0; a < t; a++) {
            buffer.append("java");
        }
        l=System.currentTimeMillis()-l;
        System.out.println(l);

        l=System.currentTimeMillis();
        //不考虑线程
        StringBuilder builder=new StringBuilder("hell0");
        for (int a = 0; a < t; a++) {
            builder.append("java");
        }
        l=System.currentTimeMillis()-l;
        System.out.println(l);
    }
}
