package com.newer.thread.subThread;

/**
 * Created by json on 2017/3/3.
 */
public class appp {
    public static void main(String[] args) {

        //join();开始
        //yield();运行线程让出处理器时间
        int i=0;
        while(true){
            System.out.println("#############");
            //当前线程让出处理器时间
            Thread.yield();
        }
    }
}
