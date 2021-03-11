package _并发和多线程._AQS;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: _Semaphore实现生产者消费者模式
 * @Author: lerry_li
 * @CreateTime: 2021/03/11
 * @Description
 */
public class _Semaphore实现生产者消费者模式 {
    LinkedList queue = new LinkedList();//线程安全的队列
    final int MAX = 100;
    Semaphore empty = new Semaphore(MAX);
    Semaphore full = new Semaphore(0);

    public void produce() throws InterruptedException {
        empty.acquire();
        synchronized (queue) {
            //操作队列
        }
        full.release();
    }

    public void consume() throws InterruptedException {
        full.acquire();
        synchronized (queue) {
            //操作队列
        }
        empty.release();
    }
}
