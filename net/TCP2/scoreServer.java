package com.newer.net.TCP2;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

/**
 * 执行分数查询的服务（多线程）
 * Created by json on 2017/3/7.
 */
public class scoreServer implements  Runnable{

    private Socket socket;
    private HashMap<String,Integer>scores;
    /**
     * 构造方法
     * @param socket    套接字
     * @param scores    成绩
     */
    public scoreServer(Socket socket, HashMap<String, Integer> scores) {

        this.socket=socket;
        this.scores=scores;
    }

    @Override
    public void run() {

        try (
                InputStream in=socket.getInputStream();
                OutputStream out=socket.getOutputStream()){

            byte[]buf=new byte[1024];
            while (true){
                int size=in.read(buf);
                String name=new String(buf,0,size);

//                int score=scores.get(name);

                String score="用户不存在";
                if(scores.containsKey(name)){
                    score=String.valueOf(scores.get(name));
                }
                System.out.printf("%s的成绩：%s\n",name,score);
                out.write(score.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
