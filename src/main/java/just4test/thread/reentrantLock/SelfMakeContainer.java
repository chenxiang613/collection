package just4test.thread.reentrantLock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 经典面试题：写一个固定容量的容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * <p>
 * 点：生产者消费者模式
 * <p>
 * 如果调用 get方法时，容器为空，get方法就需要阻塞等待
 * 如果调用 put方法时，容器满了，put方法就需要阻塞等待
 * <p>
 * 实现方式：
 * 1. wait/notify
 * 2. Condition
 * <p>
 * <p>
 * 使用Lock和Condition实现，可以精确唤醒某些线程
 */
public class SelfMakeContainer<T> {

    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX = 10;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public  void put(T t) {
        lock.lock();
        try {
            while (list.size()== MAX ) {
                System.out.println("wait to consume");
                producer.await();
            }
            list.add(t);
            System.out.println("list size: "+list.size() + " list++");
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  T get() {
        lock.lock();
        try {
            while (list.size() == 0) {
                System.out.println("wait to produce");
                consumer.await();
            }
            T t = list.removeFirst();
            System.out.println("list size: "+list.size() + " list--");
            producer.signalAll();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        SelfMakeContainer<String> c = new SelfMakeContainer<>();
        // 启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true){
                    System.out.println(c.get());
                }
            }, "c_" + i ).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                while (true) {
                    c.put(Thread.currentThread().getName() + " ");
                }
            }, "p_" + i).start();
        }
    }
}

