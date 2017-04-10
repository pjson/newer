package com.newer.net.TCP2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by json on 2017/3/7.
 */
public class Client {
    public static void main(String[] args) throws Exception {
//        aboutAddress();

        //客户端

        //连接服务器
        Socket socket=new Socket(InetAddress.getLocalHost(),2000);

        //建立连接
        //三次握手
        //通信
        Scanner sc=new Scanner(System.in);
        InputStream in=null;//
        OutputStream out=null;

        in=socket.getInputStream();
        out=socket.getOutputStream();

        while(true){
            System.out.print("输入姓名：");
            String name=sc.nextLine();
            //发送数据
            out.write(name.getBytes());//把名字变成字节数组发送
            out.flush();//写操作是带缓冲的，写操作时一定要写刷新
            //接收数据
            byte []buf=new byte[1024*2];//定义一个缓冲区
            int size=in.read(buf);
            String data=new String(buf,0,size);
            System.out.println("查询到的成绩:"+data);
            //是否继续
            System.out.print("是否继续查询成绩（v):");
            String go=sc.nextLine();
            if(!go.equalsIgnoreCase("y")){
                break;
            }
        }

    }

    private static void aboutAddress() throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getLoopbackAddress();//得到地址127.0.0.1
        System.out.println(InetAddress.getLoopbackAddress());
        System.out.println(InetAddress.getLocalHost());//获得本机地址
        System.out.println(InetAddress.getByName("www.baidu.com"));
        System.out.println(InetAddress.getByName("jon"));

    }
}
