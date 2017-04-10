package com.newer.thread.a_bThread;

/**
 * Created by json on 2017/3/2.
 */
public class App {
    public static void main(String[] args) {
       /* System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);

        //获得当前线程的实例
        Thread t1=Thread.currentThread();
        t1.setName("happy");//修改线程名称
        t1.setPriority(2);//修改优先级
        System.out.println(t1.getName());//
        System.out.println(t1.getId());
        System.out.println(t1.getPriority());
        System.out.println(t1.getState());*/

        //创建线程（存在）
        AThread a=new AThread();
        a.setName("男");
        BThread b=new BThread();
        b.setName("女");
//        //设置优先级
//        //但是优先级对线程的改变并不明显
//        a.setPriority(10);
//        b.setPriority(1);

        //设置b为守护线程（线程a结束后b也结束）
        b.setDaemon(true);

        //start  线程进入就绪状态
        //a线程在前面，但是运行时候a不一定在b的前面
        //a执行完一次后不一定就会执行b
        //要看cpu片谁先被选中
        a.start();
        b.start();
    }
}
