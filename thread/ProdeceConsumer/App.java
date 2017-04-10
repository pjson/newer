package com.newer.thread.ProdeceConsumer;

/**
 * Created by json on 2017/3/4.
 */
public class App {
    public static void main(String[] args) {
        //仓库（资源）
        Store store=new Store();

        Producer producer=new Producer(store);
        producer.setName("生产者");
        Consumer consumer=new Consumer(store);
        consumer.setName("消费者");

        producer.start();

        consumer.start();


    }
}
