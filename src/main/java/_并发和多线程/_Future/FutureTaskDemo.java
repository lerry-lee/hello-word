package _并发和多线程._Future;

import java.util.concurrent.*;

/**
 * @ClassName: FutureTaskDemo
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description 使用FutureTask获取结果
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        FutureTask futureTask = new FutureTask<>(task);
        //1.直接创建一个线程执行
//        new Thread(futureTask).start();
        //2.使用线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(futureTask);
        threadPool.shutdown();
        System.out.println(futureTask.get());
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
