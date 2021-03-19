package _并发和多线程._常见的同步器._condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ConditionDemo2
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description 使用Condition实现生产者消费者模式
 */
public class ConditionDemo2 {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);
    private Lock lock = new ReentrantLock();
    private Condition canProduce = lock.newCondition();
    private Condition canConsume = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo2 instance = new ConditionDemo2();
        Producer producer = instance.new Producer();
        Consumer consumer = instance.new Consumer();
        producer.start();
        consumer.start();
    }

    //生产者
    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        System.out.println("队列满，等待有空余（等待消费）");
                        try {
                            //可生产就得阻塞
                            canProduce.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //生产一个消息
                    queue.offer(0);
                    //可继续消费了，唤醒阻塞的消费者
                    canConsume.signalAll();
                    System.out.println("向队列里生产一个消息，队列剩余" + queue.size() + "个元素");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    //消费者
    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列空，等待数据");
                        try {
                            //可消费就得阻塞
                            canConsume.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //消费一个消息
                    queue.poll();
                    //可继续生产了，唤醒阻塞的生产者
                    canProduce.signalAll();
                    System.out.println("从队列里获取一个消息，队列剩余" + queue.size() + "个元素");
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
