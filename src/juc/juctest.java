package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huqi
 * @creat 2020-05-25 21:02
 * @description
 */
public class juctest {

    public static void main(String[] args) {
jucdemo jd=new jucdemo();

     for(int i=0;i<10;i++)
     {
         new Thread(jd).start();
     }

    }
}
class jucdemo implements  Runnable {

    private AtomicInteger num=new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num.getAndIncrement();

        System.out.println(num);
    }

    public AtomicInteger returnnum() {

        return num;
    }

}
