package com.newer.net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by json on 2017/3/6.
 */
public class Client {
    public static void main(String[] args) throws IOException {
//        Socket socket=new Socket("127.0.0.1",3000);
        //socket与服务器通过端口进行连接
        Socket socket=new Socket(InetAddress.getLocalHost(),3000);
        try(
                InputStream in=socket.getInputStream();
                OutputStream out=socket.getOutputStream()){
            while(true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("#  ");
                String input = sc.nextLine();
                //发送数据
                out.write(input.getBytes());
                System.out.println("已发送。。。");

                if(input.equalsIgnoreCase("byy")){
                    break;
                }
                //接收数据
                byte[] buf = new byte[1024];
                int size = in.read(buf);
                String data = new String(buf, 0, size);
                System.out.println("收到:" + data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
