package com.newer.net.UDP.chat_UDPThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 定义任务（接收任务
 * Created by json on 2017/3/10.
 */
public class ReceiverTask implements Runnable {

    private DatagramSocket socket;

    public ReceiverTask(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            while (!Thread.interrupted()) {

                socket.receive(p);

                String msg = new String(p.getData(), p.getOffset(), p.getLength());
                System.out.printf("接收:" + msg);
            }
            }catch (Exception e) {
                e.printStackTrace();
            }

    }
}
