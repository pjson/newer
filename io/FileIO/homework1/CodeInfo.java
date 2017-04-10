package com.newer.io.FileIO.homework1;

/**
 * Created by json on 2017/2/23.
 */
public class CodeInfo {
    int blank;
    int total;
    int comment;
    int code;
    public void print(){
        System.out.println("总行数:"+total);
        System.out.println("空行数:"+blank);
        System.out.println("代码行数:"+code);
        System.out.println("注释行数:"+comment);
    }
    public int codeCount(){
        return code=total-blank-comment;
    }

}
