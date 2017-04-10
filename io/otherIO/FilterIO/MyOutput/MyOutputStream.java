package com.newer.io.otherIO.FilterIO.MyOutput;

import java.io.*;

public class MyOutputStream extends FilterOutputStream {

	public MyOutputStream(OutputStream out) {
		super(out);
	}
//	public void write(int b) throws IOException {
//		out.write(b);
//	}
	@Override
	public void write(int b) throws IOException {
		super.write(b + 1);
	}
//	public void write(byte b[]) throws IOException {
//		write(b, 0, b.length);
//	}
	@Override
	public void write(byte[] b) throws IOException {
		for (int i = 0; i < b.length; i++) {
			char c = (char) b[i];
			b[i] = (byte) --c;
		}
		super.write(b);
	}
}
