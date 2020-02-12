package just4test.thread.collection4test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue4T {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue(5);
        ExecutorService service = Executors.newFixedThreadPool(3);
        new Thread(() -> {
            try {
                while (true){
                    blockingQueue.take();
                    System.out.println("消费1个，blockingQueue.size:" + blockingQueue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "p").start();

        for (int i = 0; i < 3; i++) { // 执行六个任务,  在只有五个固定容量的线程池中
            //这里是匿名内部类+lambda,
            service.execute(() -> {
                try {
                    while (true){
                        blockingQueue.put(1);
                        System.out.println("生产1个，blockingQueue.size:" + blockingQueue.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }






//        new Thread(() -> {
//            try {
//                while (true){
//                    for (int i = 0; i < 5 ; i++) {
//                        blockingQueue.put(i);
//                        System.out.println("生产1个，blockingQueue.size:" + blockingQueue.size());
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "p").start();
//
//        for (int i = 0; i < 3; i++) { // 执行六个任务,  在只有五个固定容量的线程池中
//            //这里是匿名内部类+lambda,
//            service.execute(() -> {
//                try {
//                    while (true){
//                        blockingQueue.take();
//                        System.out.println("消费1个，blockingQueue.size:" + blockingQueue.size());
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
    }
}
