package com.newer.net.UDP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

/**
 * UDP  发送方
 * Created by json on 2017/3/10.
 */
public class Sender {
    public static void main(String[] args) {
        try {
            //创建UDP 套接字
            DatagramSocket socket=new DatagramSocket();
            Scanner scanner=new Scanner(System.in);

            while(true) {
                System.out.print("输入信息：");
                String msg=scanner.nextLine();
//                String msg = "hello UDP 你好";
                byte[] data = msg.getBytes("UTF-8");//得到数据字符数组

                //数据包
                DatagramPacket packet =
                        new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 3001);
                //发送数据
                socket.send(packet);
                System.out.println("已发送。。。。");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
