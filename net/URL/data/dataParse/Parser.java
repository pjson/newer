package com.newer.net.URL.data.dataParse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 定义=一个解析器（功能：解析一个文件((
 * Created by json on 2017/3/14.
 */
public class Parser {
    //依赖
    Handler handler=null;

    public Parser(Handler handler){
        this.handler=handler;
    }
//    public void setHandler(Handler handler){
//        this.handler=handler;
//    }
    /**
     * 解析（回调）
     * @param file
     */
    public void parse(File file){

        try (BufferedReader in=
                    new BufferedReader(
                            new FileReader(file))){
            handler.startFile();

            handler.startTag("a");
            handler.text("");
            handler.endFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回调方法：你实现，你不直接调用
     */
    public static interface Handler{
        void startFile();
        void startTag(String tag);
        void text(String text);
        void endTag(String tag);
        void endFile();
    }
}
