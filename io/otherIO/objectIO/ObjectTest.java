package com.newer.io.otherIO.objectIO;

import java.io.*;

/**
 * Created by json on 2017/2/23.
 */
public class ObjectTest {
    public static void main(String[] args) {
        //写入
        objectWrite();
        //读写
//        objectRead();
    }

    /**
     * 序列化是对于对象的，所以在对象上的类实现序列化接口
     * 序列化  obj（对象）--->数组byte[]
     * 目的：写入文件（网络发送，传输）
     * 反序列化  数组byte[]--->obj(对象）
     * 目的：读入文件（还原）
     */

    private static void objectRead() {
        try (ObjectInputStream in=
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream("a.txt")))){
            objectIOperson p= (objectIOperson) in.readObject();
            System.out.println(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void objectWrite() {
        try (ObjectOutputStream out=
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream("D:\\a")))){
            objectIOperson p1=new objectIOperson("hello",22,12.1);
            out.writeObject(p1);
            System.out.println("over");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
