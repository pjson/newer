package com.newer.thread.VolatileThread;

/**
 * Created by json on 2017/3/3.
 */
public class app {
    public static void main(String[] args) throws InterruptedException {
        DemoThread demo=new DemoThread();
        //就绪
        demo.start();
        //运行

        Thread.sleep(5000);
//        demo.isRunning=false;
//        demo.shutdown();

        Thread.interrupted();
    }
}
