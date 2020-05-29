package com.hq.java;

/**
 * @author huqi
 * @create 2020-02-22
 */
class mythread implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                String s = "jkljk";
                s.contains("jkl");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


public class threadtest2 {

    public static void main(String[] args) {
        mythread m1 = new mythread();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        t1.start();
        t2.start();

    }
}
