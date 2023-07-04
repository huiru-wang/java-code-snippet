package com.snippet.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 多线程 卖票
 * 开启多个窗口，售卖固定数量的票，不能超卖
 * 生产者消费者模式
 * <p>
 * create by whr on 2023-07-03
 */
public class MultiThreadSellTickets {

    public static void main(String[] args) {
        ArrayBlockingQueue<Ticket> ticketBlockingDeque = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
        for (int i = 0; i < 100; i++) {
            ticketBlockingDeque.add(new Ticket(i));
        }
        for (int i = 0; i < 10; i++) {
            TicketWindow ticketWindow = new TicketWindow(i + "", ticketBlockingDeque);
            threadPoolExecutor.submit(ticketWindow);
        }
        threadPoolExecutor.shutdown();
    }
}

class Ticket {
    private final Integer ticketNo;

    public Ticket(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Integer getTicketNo() {
        return ticketNo;
    }
}

class TicketWindow implements Runnable {

    private final String windowName;
    private final ArrayBlockingQueue<Ticket> TICKETS_QUEUE;

    public TicketWindow(String windowName, ArrayBlockingQueue<Ticket> ticketBlockingDeque) {
        this.windowName = windowName;
        this.TICKETS_QUEUE = ticketBlockingDeque;
    }

    @Override
    public void run() {
        while (!TICKETS_QUEUE.isEmpty()) {
            try {
                Ticket poll = TICKETS_QUEUE.poll(1L, TimeUnit.SECONDS);
                System.out.println("Window-" + windowName + " Sell Ticket" + poll.getTicketNo());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
