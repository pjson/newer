package com.newer.thread.pool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by json on 2017/3/4.
 */
public class Pool {
    public static void main(String[] args) {

//        int a[]={3,1,2,9,6};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));


//        Executor executor;
        //1个线程池   3个线程
        //固定大小
        ExecutorService pool=Executors.newFixedThreadPool(3);

        //可缓存的（大小不受控制）
        ExecutorService pool1=Executors.newCachedThreadPool();

        //单例(1个线程）
        ExecutorService pool2=Executors.newSingleThreadExecutor();
        //10个任务
        for(int i=1;i<=10;i++){
            pool.submit(new MyTask("t  "+i));
        }
        //结束线程池
        pool.shutdown();


        //轮巡（定时的间隔进行工作）
        ScheduledExecutorService spool=Executors.newScheduledThreadPool(4);
        spool.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+"  "+new Date().toLocaleString());
                    }
                },
                0,
                2,
                TimeUnit.SECONDS);


    }
}
