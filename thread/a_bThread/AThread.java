package com.newer.thread.a_bThread;

/**
 * Created by json on 2017/3/2.
 */
public class AThread extends Thread {
    //成员变量
    String[]text={"1","2","3","4"};
    //重写一个方法
    @Override
    public void run() {
        super.run();

        int i=0;
        while(true){
//            if(i==text.length){
//                i=0;
//            }
            if(i>=text.length){
                break;
            }
            //求余   复位
            System.out.println(getName()+text[i++ % text.length]);
            try {
                //当前线程让出处理器进入休眠，结束后，继续等待处理器捕获
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
