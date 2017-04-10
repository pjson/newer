package com.newer.io.otherIO.FilterIO;

import java.io.*;

/**
 * Created by json on 2017/2/25.
 */
public class CaesarTest {
    public static void main(String[] args) {
//        write();

        read();
    }

    private static void read() {
        try(CaesarReader in=
                    new CaesarReader(
                            new FileReader("D:\\a"))){
            //缓冲区（字母数组）
            //把文件中数据写入到缓冲区（字母数组）
            CharArrayWriter caw=new CharArrayWriter(32);
            int n;
            while(-1!=(n=in.read())){
                caw.write(n);
            }
            String msg=caw.toString();
            System.out.println(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void write() {
        String msg="hello 123";
        try(CaesarWriter out=
                    new CaesarWriter(
                            new FileWriter("D:\\a"))){
            out.write(msg);
            System.out.println("over");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
