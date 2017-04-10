package com.newer.net.URL;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 下载文件
 * Created by 何子洋 on 2017/3/11.
 */
public class App {
    public static void main(String[] args) {
//        loadText();
        try {
            loadImg(new URL("https://www.baidu.com/img/bd_logo1.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void loadImg(URL url) {
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setReadTimeout(10000);
            conn.connect();
            if (200 == conn.getResponseCode()) {
                System.out.println(conn.getResponseMessage());
                // 获得数据
                BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
                byte[] buf = new byte[1024 * 8];
                ByteArrayOutputStream out = new ByteArrayOutputStream(1024 * 8);
                int size;
                while (-1 != (size = in.read(buf))) {
                    out.write(buf, 0, size);
                }
                byte[] data = out.toByteArray();
                byte[] md5 = MessageDigest.getInstance("MD5").digest(data);
                String name = new BigInteger(1, md5).toString(16);
                FileOutputStream outputStream = new FileOutputStream(name);
                outputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void loadText() {
        HttpURLConnection connection;
        try {
            URL url = new URL("http://www.codeflyer-zy.com");
            // HTTP 连接，TCP 套接字
            connection = (HttpURLConnection) url.openConnection();
            // 设置请求方法-GET
            connection.setRequestMethod("GET");
            // 连接超时
            connection.setConnectTimeout(5000);
            // 读取超时
            connection.setReadTimeout(10000);
            // 连接
            connection.connect();
            // 获得响应码
            int code = connection.getResponseCode();
            System.out.println(code);
            if (code == 200) {
                // 获得输入流
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                char[] buf = new char[1024 * 8];
                // 1 StringBuilder builder
                // 2 CharArrayWriter out
//                StringBuilder builder = new StringBuilder();
                //字节数组书写器
                CharArrayWriter out = new CharArrayWriter(1024 * 8);
                int size;
                while (-1 != (size = in.read(buf))) {
//                    builder.append(buf, 0, size);
                    out.write(buf, 0, size);
                }
                char[] data = out.toCharArray();
//                System.out.println(builder.toString());
                System.out.println(data.length);
                System.out.println(new String(data));
                FileWriter writer = new FileWriter("a.txt");
                writer.write(data, 0, data.length);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
