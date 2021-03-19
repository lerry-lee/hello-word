package _并发和多线程._atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: AtomicLongDemo
 * @Author: lerry_li
 * @CreateTime: 2021/03/20
 * @Description 演示高并发场景下，LongAdder比AtomicLong性能好
 */
public class AtomicLongDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong counter = new AtomicLong(0);
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        //计时
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            threadPool.execute(new Task(counter));
        }
        threadPool.shutdown();
        while (!threadPool.isTerminated()) ;
        //计时
        long end = System.currentTimeMillis();
        System.out.println(counter.get());
        System.out.println("AtomicLong耗时：" + (end - start) + "ms");
    }

    /**
     * 每次执行任务，循环10000次，对counter+1
     */
    private static class Task implements Runnable {

        private AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        }
    }
}
