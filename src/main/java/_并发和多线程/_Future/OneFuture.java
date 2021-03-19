package _并发和多线程._Future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName: OneFuture
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class OneFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPoll = Executors.newFixedThreadPool(5);
        Future<Integer> future = threadPoll.submit(new Task());
        System.out.println(future.get());
        threadPoll.shutdown();
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
