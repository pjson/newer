package com.newer.thread.ProdeceConsumer;

/**
 * Created by json on 2017/3/4.
 */
public class Producer extends Thread {
    private Store store;
    public Producer(Store store) {
        this.store=store;
    }
    public void run(){
        super.run();

        int i=1;
        while(true){
            try {
                //生产者不断进行生产
                store.put(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }


}
