package com.newer.thread.ProdeceConsumer;

import java.util.LinkedList;

/**
 * Created by json on 2017/3/4.
 */
public class Store {
    public static final  int SIZE=5;
    LinkedList<Integer>list;
    public Store(){
        list=new LinkedList<>();
    }

    /**
     * 生产者
     * @param n
     * @throws InterruptedException
     */
    public  synchronized void put(int n) throws InterruptedException {
        if(list.size()<5){
            //生产
            list.add(n);
            //通知
            notifyAll();
            System.out.println(Thread.currentThread().getName()+" "+n);

        }else {
            //队列满了
//            Thread.yield();//执行该方法的线程进入到就绪

            System.out.println(Thread.currentThread().getName()+"wait...");

            //当前线程让出处理器时间，解锁，添加了该对象的监视器
            this.wait();//执行该方法的线程进入到等待状态
        }
    }

    /**
     * 消费者
     * @return
     * @throws InterruptedException
     */
    public synchronized int get() throws InterruptedException {
        int n=-1;

        if(!list.isEmpty()){
            //不为空
            n=list.getFirst();
//            n=list.removeFirst();

            //通知持有该对象监视器（等待的线程）的线程
//            this.notify();//通知该对象监视器的线程
            this.notifyAll();//通知所有有监视器的线程
            System.out.println(Thread.currentThread().getName()+""+n);
        }else {
            System.out.println(Thread.currentThread().getName()+"wait...");
            //空
            this.wait();
        }
        return n;
    }

}
