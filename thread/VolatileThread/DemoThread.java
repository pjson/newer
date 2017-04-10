package com.newer.thread.VolatileThread;

import java.util.Date;

/**
 * Created by json on 2017/3/3.
 */
public class DemoThread extends Thread {
    //关键字volatile
    //线程每次使用变量的时候，就会读取变量修改后的值
    volatile boolean isRunning=true;

    public void run(){
        super.run();
        while(isRunning){

            if(isInterrupted()){
                //如果被中断，结束循环
                break;
            }
            System.out.println(new Date().toLocaleString());
            /*try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                //被中断
                break;
            }*/
            System.out.println(getName()+"结束");
        }
    }
    public void shutdown(){
        isRunning=false;
    }
}
