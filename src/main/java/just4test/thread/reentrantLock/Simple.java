package just4test.thread.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Simple {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //t1线程尝试加锁，并执行相关操作
        new Thread(() -> {
            lock.lock();
            try {
                for (int j = 0; j < 5; j++) {
                    System.out.println("sleep 1 second");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1" ).start();

        //t2线程也尝试加锁,但是一直被阻塞，原因是t1线程加锁后未unlock释放
        new Thread(() -> {
            lock.lock();
            try {
                for (int j = 0; j < 5; j++) {
                    System.out.println("wa ha ha");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.lock();
            }
        }, "t2").start();
    }
}
