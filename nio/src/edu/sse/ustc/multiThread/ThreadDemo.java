package edu.sse.ustc.multiThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 创建线程的几种方式
 */
public class ThreadDemo {

    public static void main(String[] args) {
        // 方式一：继承Thread类
        MyThread myThread = new MyThread();
        myThread.start();

        // 方式二：实现Runnable接口
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();

        // 方式三：实现Callable接口
        MyThread3 myThread3 = new MyThread3();

        // 方式四：线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while(true){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread Run...");
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread Run ...");
    }
}

class MyThread3 implements Callable{

    @Override
    public Object call() throws Exception {
        return "";
    }
}


