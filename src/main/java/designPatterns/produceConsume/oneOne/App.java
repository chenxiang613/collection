package designPatterns.produceConsume.oneOne;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  {
	    Object lock = new Object();
		BaoziStore baoziStore = new BaoziStore();
        Queue<Baozi> baozis = new LinkedList<Baozi>();
		new Thread(() -> {
			while (true){
				synchronized (lock){
					//如果包子没有了就生产包子，否则就用wait让出CUP
					if(baozis.size() == 0){
						baoziStore.produce(baozis);
					}else{
                        System.out.println(baozis.size() + " baozis remain ,please eat ");
						try {
                            lock.notify();
                            lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		},"producerThread").start();

        new Thread(() ->{
            Customer customer = new Customer("AXiong");
            while (true){
                synchronized (lock){
                    if(baozis.size() > 0){
                        customer.eatBaozi(baozis);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println("start notify baoziStore to produce");
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("already notify baoziStore to produce");
                    }
                }
            }
        },"consumerThread:").start();
	}
}
