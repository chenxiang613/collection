package just4test.thread.reentrantLock;

import java.util.LinkedList;
import java.util.Random;

public class WaitAndNotify {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        int capacity = 10;
        Object lock = new Object();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (lock){
                        while (capacity == intList.size()){
                            System.out.println("wait to consume");
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        intList.add(100);
                        System.out.println("list size: "+intList.size() + " list++");
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "producer"+i+1).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                   synchronized (lock){
                       while (0 == intList.size()){
                           System.out.println("wait to produce");
                           try {
                               lock.wait();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                       intList.removeFirst();
                       System.out.println("list size: "+intList.size() + " list+--");
                       lock.notifyAll();
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                }
            }, "consumer"+i+1).start();
        }
    }
}
