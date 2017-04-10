package com.newer.io.otherIO.FilterIO.MyOutput;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by json on 2017/2/26.
 */
public class MyInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected MyInputStream(InputStream in) {
        super(in);
    }
    public int read() throws IOException {
        return in.read();
//        return super.read();
    }
    public int read(byte[]data) throws IOException {
        for (byte b : data) {
            char c=(char)++b;
            b=(byte)c;
        }
        return super.read(data);
    }
}
