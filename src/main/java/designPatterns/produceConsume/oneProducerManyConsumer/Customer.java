package designPatterns.produceConsume.oneProducerManyConsumer;

import java.util.Queue;

public class Customer {
    private String name;
    public void eatBaozi(Queue<Baozi> baozis){
        Baozi baozi = baozis.poll();
        System.out.println(Thread.currentThread().getName() + " eat " + baozi.stuffing + " baozi");
    }

    public Customer(String name) {
        this.name = name;
    }
}
