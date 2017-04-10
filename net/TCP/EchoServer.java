package com.newer.net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by json on 2017/3/6.
 */
public class EchoServer {
    //端口号
    private int port=3000;
    //服务器套接字
    private ServerSocket serverSocket;

    //启动
    public void start(){
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("Echo  服务器已经启动...");

            //创建一个线程池（有8个线程）
            ExecutorService pool=Executors.newFixedThreadPool(8);
            //接收请求，提供服务
            //accept()方法出现不会发生阻塞
            while(true) {
                Socket socket = serverSocket.accept();

                pool.submit(new Runnable() {
                    @Override
                    //线程池内执行的任务
                    public void run() {
                        System.out.println(
                                Thread.currentThread().getName()
                                +"处理"
                                +socket.getPort()
                        );
                        try(
                                InputStream in=socket.getInputStream(); //接收数据
                                OutputStream out=socket.getOutputStream()) {

                            //接收来自客户端的数据
                            byte[]buf=new byte[1024];
                            int size=in.read(buf);
                            String data=new String(buf,0,size);
                            System.out.println("收到："+data);

                            //向客户端发数据
                            data=data.toUpperCase();
                            out.write(data.getBytes());
                            out.flush();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        //发送数据

                    }
                });
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EchoServer server=new EchoServer();
        server.start();
    }
}
