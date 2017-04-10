package com.newer.io.otherIO.FilterIO;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 自定义IO流
 * Created by json on 2017/2/23.
 */
public class FilterIO extends FilterOutputStream {
    public static void main(String[] args) {

    }
    public FilterIO(OutputStream out) {
        super(out);
    }

    public void write(int b) throws IOException {
        super.write(b - 1);
    }

    public void write(byte[] b) throws IOException {
        for (int i = 0; i < b.length; i++) {
            b[i]--;
        }
        super.write(b);
    }
}
