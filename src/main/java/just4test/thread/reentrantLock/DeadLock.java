package just4test.thread.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public static void main(String[] args) {
        Lock firstLock = new ReentrantLock();
        Lock secondLock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            firstLock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("t1线程尝试secondLock");
                secondLock.lock();
                System.out.println("t1线程获取secondLock");
                System.out.println("t1线程在干活");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
            }

        }, "1Thread");

        Thread t2 = new Thread(() -> {
            secondLock.lock();
            try {
                System.out.println("t2线程尝试firstLock");
                firstLock.lock();
                System.out.println("t2线程获取firstLock");
                System.out.println("t2线程在干活");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("");
            } finally {
                secondLock.unlock();
                firstLock.unlock();
            }

        }, "2Thread");
        t1.start();
        t2.start();
        //因为前面t2线程加的是不可中断的锁，执行interrupt也没卵用
        t2.interrupt();
    }
}
