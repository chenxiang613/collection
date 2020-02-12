package just4test.thread.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interrupt {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //t1线程尝试加锁，并执行相关操作
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                for (int j = 0; j < 5; j++) {
                    System.out.println("t1 sleep 1 second");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1" );

        //t2线程也尝试加锁,但是一直被阻塞，原因是t1线程加锁后未unlock释放
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("手动打断锁");
                TimeUnit.SECONDS.sleep(1);
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("成功打断锁");
                lock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
        t2.interrupt();
    }
}
