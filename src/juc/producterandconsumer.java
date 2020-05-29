package juc;

/**
 * @author huqi
 * @creat 2020-05-26 17:13
 * @description
 */
public class producterandconsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producter producter = new Producter(clerk);
        Consumer1 consumer = new Consumer1(clerk);
new Thread(producter,"生产者A").start();
new Thread(consumer,"消费者B").start();

    }

}

class Clerk {
    private static int product=0;

    public synchronized void get() {
       while(product >= 10) {
            System.out.println("产品已满");
            try {
                this.wait();
            } catch (Exception e) {
            }
        }

            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            this.notifyAll();

    }

    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            this.notifyAll();

    }
}

class Producter implements Runnable {
    private Clerk clerk;

    Producter(Clerk clerk) {
        this.clerk = clerk;

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }

}

class Consumer1 implements Runnable {

    private Clerk clerk;

    Consumer1(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sale();
        }

    }
}