package designPatterns.produceConsume.oneOneCountDownLatch;

import java.util.Queue;

public class BaoziStore {
//    public List<Baozi> baozis = new ArrayList<Baozi>();

    public void produce(Queue<Baozi> baozis){
        System.out.println("baoziStore produre baozis");
        for (int i = 0; i < 5; i++) {
            if(i%2 == 0){
                baozis.add(new Baozi("pork"));
            }else{
                baozis.add(new Baozi("beef"));
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("baozis is produced");
    }
}
