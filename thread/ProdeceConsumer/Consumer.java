package com.newer.thread.ProdeceConsumer;

/**
 * Created by json on 2017/3/4.
 */
public class Consumer extends Thread {

    private Store store;

    public Consumer(Store store) {
        this.store=store;
    }

    public void run() {
        super.run();

        while (true) {
            try {
                //消费者不断进行消费
                int n=store.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
