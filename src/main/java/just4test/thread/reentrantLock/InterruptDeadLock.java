package just4test.thread.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptDeadLock {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new ThreadDemo(lock1, lock2));//该线程先获取锁1,再获取锁2
        Thread thread2 = new Thread(new ThreadDemo(lock2, lock1));//该线程先获取锁2,再获取锁1
        thread1.setName("t1");
        thread1.start();
        thread2.setName("t2");
        thread2.start();
        int i = 1;
        while(i<6){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("mian thread sleep " + i + " seconds");
            i++;
        }
        thread2.interrupt();//是第一个线程中断
    }

    static class ThreadDemo implements Runnable {
        Lock firstLock;
        Lock secondLock;
        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }
        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();
                TimeUnit.MILLISECONDS.sleep(3);//更好的触发死锁
                secondLock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "线程被interrupt");
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName()+"正常结束!");
            }
        }
    }
}