package com.newer.net.UDP.chat_UDPThread;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by json on 2017/3/10.
 */
public class Chat {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.printf("指定端口號：");
        int port=Integer.parseInt(sc.nextLine());

        //给数据报一个套接字
        DatagramSocket socket=null;
        try {
            socket = new DatagramSocket(port);
            //创建，启动发送线程
            SenderThread senderThread = new SenderThread(socket);
            senderThread.start();

            //创建，启动接收线程
            //给接收线程分配一个任务
            Thread receiverThread = new Thread(new ReceiverTask(socket));
            receiverThread.start();
        }catch (SocketException e){
            e.printStackTrace();
        }
    }
}
