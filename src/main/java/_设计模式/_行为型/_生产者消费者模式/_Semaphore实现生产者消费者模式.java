package _设计模式._行为型._生产者消费者模式;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: _Semaphore实现生产者消费者模式
 * @Author: lerry_li
 * @CreateTime: 2021/03/11
 * @Description 信号量实现生产者消费者模式
 */
public class _Semaphore实现生产者消费者模式 {

    LinkedList queue = new LinkedList();//线程安全的队列
    final int MAX = 100;
    Semaphore canProduce = new Semaphore(MAX);
    Semaphore canConsume = new Semaphore(0);

    //生产者
    public void produce() throws InterruptedException {
        //如果可生产，则可生产的数量-1
        canProduce.acquire();
        synchronized (queue) {
            //操作队列
        }
        //生产完，可消费的数量+1
        canConsume.release();
    }

    //消费者
    public void consume() throws InterruptedException {
        //如果可消费，则可消费的数量-1
        canConsume.acquire();
        synchronized (queue) {
            //操作队列
        }
        //消费完，可生产的数量+1
        canProduce.release();
    }
}
