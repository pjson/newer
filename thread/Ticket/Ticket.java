package com.newer.thread.Ticket;

/**
 * Created by json on 2017/3/2.
 */
public  class Ticket {
    int n;

    public Ticket(){
        n=10;
    }
    public synchronized int getTicket() throws NoTicketException {
        if(n<=0){
            throw new NoTicketException();
        }
        int a=n;
        try {
            //方法必须加synchronized
            //所有线程进行同步，一张票不能卖四次
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n--;
        return a;
    }
}
