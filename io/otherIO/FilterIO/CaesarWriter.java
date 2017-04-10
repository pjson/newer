package com.newer.io.otherIO.FilterIO;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/**
 * 使用凯撒密码加密写数据
 * Created by json on 2017/2/25.
 */
public class CaesarWriter extends FilterWriter{
    /**
     * Create a new filtered writer.
     *
     * @param out a Writer object to provide the underlying stream.
     * @throws NullPointerException if <code>out</code> is <code>null</code>
     */
    protected CaesarWriter(Writer out) {
        super(out);
    }
    public void write(String str)throws IOException{
        char[]data=str.toCharArray();//字符串变为数组
        System.out.println(Arrays.toString(data));//打印数组的方法
        for (int i = 0; i < data.length; i++) {
            data[i]+=13;
        }
        System.out.println(Arrays.toString(data));
        str=new String(data);//数组变为字符串
        super.write(str);
    }
}
