package com.newer.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收方
 * Created by json on 2017/3/10.
 */
public class Receiver {
    public static void main(String[] args) {

        try {
            //套接字
            DatagramSocket socket =new DatagramSocket(3001);

                while(true) {
                    //数据包(字符数组buf)
                    byte[] buf = new byte[4096];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    //从接口3000处接受数据包buf
                    System.out.println("接收方启动了。。。。");
                    socket.receive(packet);

                    //从包获取数据
                    byte[] data = packet.getData();//buf里面的数据和data中的不同
                    String msg = new String(packet.getData(), packet.getOffset(), packet.getLength());

                    int port = packet.getPort();
                    System.out.printf("收到来自%d:%s\n", port, msg);
                }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
