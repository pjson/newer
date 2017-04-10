package com.newer.thread.Ticket;

/**
 * Created by json on 2017/3/2.
 */
public class TicketApp {
    public static void main(String[] args) {
        //车票
        Ticket ticket=new Ticket();

        TicketOffice office1=new TicketOffice(ticket);
        TicketOffice office2=new TicketOffice(ticket);

        //创建窗口（线程）售票
        Thread t1=new Thread(office1,"#1");
        Thread t2=new Thread(office2,"#2");

        t1.start();
        t2.start();

        new Thread(new TicketOffice(ticket),"#3").start();
        new Thread(new TicketOffice(ticket),"#4").start();
    }
}
