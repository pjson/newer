package com.newer.net.TCP2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by json on 2017/3/7.
 */
public class TcpServer {
    public static void main(String[] args) {

        ServerSocket serverSocket;
        boolean isRunning=true;

        //成绩单（从数据库中加载成绩单）
        HashMap<String,Integer>scores=new HashMap<>();
        scores.put("a",34);
        scores.put("a",87);//HashMap集合中key可以相同，只不过会发生覆盖
        scores.put("x",24);
        scores.put("d",94);
        scores.put("n",64);

        //创建长度不确定的线程池
        ExecutorService pool= Executors.newCachedThreadPool();
        try {
            serverSocket=new ServerSocket(2000,50);
            System.out.println("服务器启动了。。。");
            while(isRunning){
                //接收请求
                final Socket socket=serverSocket.accept();
                //

                //处理请求不要在主线程main（）中实现,交给线程池pool
                pool.submit(new scoreServer(socket,scores));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
