package com.xiaohan.demo.basic.currency;

import lombok.Getter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 生产消费模型：主线程分发票，消费线程进行消费，无锁不会超卖
 */
public class MultiThreadSellTickets {

    /**
     * 卖票窗口数量
     */
    private final static int WINDOW_SIZE = 10;

    /**
     * 总票数
     */
    private final static int TICKET_SIZE = 100;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                10,
                10L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1));

        // 总票数预存放在 队列中
        ArrayBlockingQueue<Ticket> ticketBlockingDeque = new ArrayBlockingQueue<>(TICKET_SIZE);
        for (int i = 0; i < TICKET_SIZE; i++) {
            ticketBlockingDeque.add(new Ticket(i));
        }
        // 开启线程进行消费队列，完成卖票
        for (int i = 0; i < WINDOW_SIZE; i++) {
            TicketWindow ticketWindow = new TicketWindow(i + "", ticketBlockingDeque);
            threadPoolExecutor.submit(ticketWindow);
        }
        threadPoolExecutor.shutdown();
    }
}

/**
 * 任务执行的线程模型
 */
class TicketWindow implements Runnable {

    /**
     * 线程名称
     */
    private final String windowName;

    /**
     * 分发队列
     */
    private final ArrayBlockingQueue<Ticket> TICKETS_QUEUE;

    public TicketWindow(String windowName, ArrayBlockingQueue<Ticket> ticketBlockingDeque) {
        this.windowName = windowName;
        this.TICKETS_QUEUE = ticketBlockingDeque;
    }

    @Override
    public void run() {
        // 队列卖完则停止，或者可以增加中断信号，随时中断
        while (!TICKETS_QUEUE.isEmpty()) {
            try {
                // 执行任务，队列为空则阻塞
                Ticket poll = TICKETS_QUEUE.poll(1L, TimeUnit.SECONDS);
                if (null == poll) {
                    System.out.println("Tickets sold out.");
                    break;
                }
                System.out.println("Window-" + windowName + " Sell Ticket " + poll.getTicketNo());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 实体
 */
@Getter
class Ticket {

    private final Integer ticketNo;

    public Ticket(int ticketNo) {
        this.ticketNo = ticketNo;
    }
}