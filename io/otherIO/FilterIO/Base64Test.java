package com.newer.io.otherIO.FilterIO;

import java.io.*;
import java.util.Base64;

/**
 * Created by json on 2017/2/25.
 */
public class Base64Test {
    public static void main(String[] args) {
        //编码
//        encode();
        //解码
        decode();

    }


    private static void decode() {

        try (BufferedReader in =
                     new BufferedReader(
                             new FileReader("D:\\a"));
             BufferedOutputStream out =
                     new BufferedOutputStream(
                             new FileOutputStream("D:\\c.jpg"))
        ) {

            // 读文本文件获得字符串
//			CharArrayWriter writer
            StringBuilder builder = new StringBuilder();

            //建立一个缓冲区（单位），按照这个单位一下一下的读
            char[] buf = new char[1024 * 16];
            int size;

            while (-1 != (size = in.read(buf))) {
                builder.append(buf, 0, size);
            }
            String data = builder.toString();

            // 解码字符串
            byte[] result = Base64.getDecoder().decode(data);

            // 字节数组（图片的原始信息）写入文件
            out.write(result);
            System.out.println("完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void encode() {
        try (BufferedInputStream in =
                     new BufferedInputStream(
                             new FileInputStream("D:\\b.jpg"));
             BufferedOutputStream out =
                     new BufferedOutputStream(
                             new FileOutputStream("D:\\a"))
        ) {

            // 字节数组
            ByteArrayOutputStream array = new ByteArrayOutputStream();

            byte[] buf = new byte[4096];
            int size;
            while (-1 != (size = in.read(buf))) {
                array.write(buf, 0, size);
            }

            // 读入内存
            byte[] data = array.toByteArray();

            // 编码
            // apache.org
            // 1.8
            byte[] result = Base64.getEncoder().encode(data);
            // 存储
            out.write(result);
            System.out.println("完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


