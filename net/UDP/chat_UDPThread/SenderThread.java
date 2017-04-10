package com.newer.net.UDP.chat_UDPThread;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 发送数据的线程
 * Created by json on 2017/3/10.
 */
public class SenderThread extends Thread {

    private DatagramSocket socket;


    //接收线程需要套接字不一定要定义一个，可以用参数传进来
    public SenderThread(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();


        DatagramPacket d= null;
        Scanner sc=new Scanner(System.in);

        while (!isInterrupted()) {
            System.out.printf("目标端口號：");
            int port=Integer.parseInt(sc.nextLine());
            System.out.printf("發送的消息是：");
            String mgs=sc.nextLine();

        try {
            byte[]data=mgs.getBytes("UTF-8");
            d = new DatagramPacket(data,0,data.length,InetAddress.getByName("127.0.0.1"),port);


            //发数据
            socket.send(d);
            System.out.println("已發送。。。。");


        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    }
}
