package _并发和多线程._atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName: AtomicLongDemo
 * @Author: lerry_li
 * @CreateTime: 2021/03/20
 * @Description 演示高并发场景下，LongAdder比AtomicLong性能好
 */
public class LongAdderDemo {
    public static void main(String[] args) throws InterruptedException {
        LongAdder counter = new LongAdder();
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
        System.out.println(counter.sum());
        System.out.println("LongAdder耗时：" + (end - start) + "ms");
    }

    /**
     * 每次执行任务，循环10000次，对counter+1
     */
    private static class Task implements Runnable {

        private LongAdder counter;

        public Task(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }
}
