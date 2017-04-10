package com.newer.thread.a_bThread;

/**
 * Created by json on 2017/3/2.
 */
public class BThread extends Thread {


    //重写一个方法
    @Override
    public void run() {
        super.run();

        while(true){
            System.out.println(getName()+"哈哈，我是2!!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
