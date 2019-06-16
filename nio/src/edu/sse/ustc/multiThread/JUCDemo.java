package edu.sse.ustc.multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JUC
 *  线程 操作 资源类
 *  高内聚 低耦合
 */

class Ticket{
    private Integer number = 30;
    private Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + " 卖出第" + (number--) + " 票，还剩 " + (number) + "票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class JUCDemo {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
       /*
        new Thread(new Runnable() {
            @Override
            public void run() {
               for(int i = 0; i <= 40; i++){
                    ticket.sale();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<= 40; i++){
                    ticket.sale();
                }
            }
        },"B").start();*/

       // JDK8实现
        new Thread(() -> {for(int i = 0; i < 40; i++){ticket.sale();}}, "AA").start();
        new Thread(() -> {for(int i = 0; i < 40; i++){ticket.sale();}}, "BB").start();
    }
}
