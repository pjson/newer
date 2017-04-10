package com.newer.thread.pool;

/**
 * Created by json on 2017/3/4.
 */
public class MyTask implements Runnable {

    String name;
    public MyTask(String name){
        super();
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+"开始");

        int time=((int)Math.random()*5+1)*1000;//取随机数1~5000
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+"结束");
    }
}
