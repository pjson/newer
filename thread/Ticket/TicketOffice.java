package com.newer.thread.Ticket;

/**
 * Created by json on 2017/3/2.
 */
public class TicketOffice implements Runnable{
    private Ticket ticket;
    public TicketOffice(Ticket ticket) {
        this.ticket=ticket;
    }

    @Override
    public void run() {
        while(true)
            try {
            int t = ticket.getTicket();
        } catch (NoTicketException e) {
            System.out.printf("%s窗口的票已售罄:%s！！\n",
                    Thread.currentThread().getName(), e.getMessage());
        }
    }
}
