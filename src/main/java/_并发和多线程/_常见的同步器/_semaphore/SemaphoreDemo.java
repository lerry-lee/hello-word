package _并发和多线程._常见的同步器._semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreDemo
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class SemaphoreDemo {

    //许可证数量为3，采用公平策略
    static Semaphore semaphore=new Semaphore(3,true);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Task());
        }
        threadPool.shutdown();
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                //获取许可证，支持重载，可以传参表示一次要获取的许可证的数量
//                semaphore.acquire(3);
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了许可证");
            //do something
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"释放了许可证");
            //释放许可证
            semaphore.release();
        }
    }
}
