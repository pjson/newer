package com.newer.thread.subThread;

import java.util.Date;

/**
 * Created by json on 2017/3/3.
 */
public class SubThread extends Thread {
    public void run(){
        super.run();
        boolean isRun=true;

        System.out.println(getName()+"开始");
        while(isRun){
            System.out.println(new Date().toLocaleString());

            //让出处理器时间
            yield();

        }
    }
}
