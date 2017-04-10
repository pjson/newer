package com.newer.io.otherIO.FilterIO;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 使用恺撒密码解密数据
 * Created by json on 2017/2/25.
 */
public class CaesarReader extends FilterReader {
    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if <code>in</code> is <code>null</code>
     */
    protected CaesarReader(Reader in) {
        super(in);
    }
    public int read() throws IOException{
        int n=super.read();
        if(-1!=n){
            System.out.println("解密前："+((char)n));
            n-=13;
            System.out.println("解密后："+((char)n));
        }
        return n;
    }
}
