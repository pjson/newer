package com.newer.io.otherIO.FilterIO.MyOutput;

import java.io.*;

/**
 * Created by json on 2017/2/26.
 */
public class Test {
        public static void main(String[] args) {

         /*   //ifmmp234
            String msg = "abc123";

            try (MyOutputStream out = new MyOutputStream(new FileOutputStream("D:\\a"))) {

                byte[] data = msg.getBytes();
                for (byte b : data) {
                    out.write(b);
                }

                System.out.println("over");

            } catch (Exception e) {
                e.printStackTrace();
            }
*/
            try(MyInputStream in=new MyInputStream(new FileInputStream("D:\\a"))){
//                int readData=in.read();
//                System.out.println(readData);


                byte[]buf=new byte[1024*2];
                int size;
//                字节数组输出流（写入到内存中）
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                //字符数组的输出流（写入到内存中）
//                CharArrayWriter caw=new CharArrayWriter();
                //可变的字符数组
//                StringBuilder s=new StringBuilder();
                while(-1!=(size=in.read(buf))){
                    //写哪
                    baos.write(buf,0,size);


                }
                System.out.println(baos);
                System.out.println("over");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
}
