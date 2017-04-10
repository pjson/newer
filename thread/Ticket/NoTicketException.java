package com.newer.thread.Ticket;

/**
 * 自定义异常
 * Created by json on 2017/3/2.
 */
public class NoTicketException extends Throwable {

    public NoTicketException() {
        super("票已售完");
    }
}
