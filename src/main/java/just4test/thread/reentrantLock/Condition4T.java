package just4test.thread.reentrantLock;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Condition4T {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        int capacity = 10;
        ReentrantLock lock = new ReentrantLock();
        Condition consumer = lock.newCondition();
        Condition producer = lock.newCondition();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        while (capacity == intList.size()){
                            System.out.println("wait to consume");
                            producer.await();
                        }
                        intList.add(100);
                        System.out.println("list size: "+intList.size() + " list++");
                        consumer.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }, "producer"+i+1).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        while (0 == intList.size()){
                            System.out.println("wait to produce");
                            consumer.await();
                        }
                        intList.removeFirst();
                        System.out.println("list size: "+intList.size() + " list+--");
                        producer.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }, "consumer"+i+1).start();
        }
        System.out.println("sssssssssssssss");
    }
}
