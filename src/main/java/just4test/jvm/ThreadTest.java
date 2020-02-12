package just4test.jvm;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ThreadTest {
	private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,1);

	public static void main(String[] args) {
		new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("t1线程初始stamp： "+stamp);
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            boolean flag1 = atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("t1线程执行一次cas,结果"+flag1);
            boolean flag2 = atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("t1线程执行二次cas,结果"+flag2);
        },"t1").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("t2线程初始stamp： "+stamp);
            try { Thread.sleep(2500); } catch (InterruptedException e) { e.printStackTrace(); }
            boolean flag = atomicStampedReference.compareAndSet(100,101,stamp,stamp+1);
            System.out.println("t2线程执行一次cas,结果"+flag);
        },"t2").start();
	}
}
