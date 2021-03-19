package _设计模式._行为型._生产者消费者模式;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ProducerConsumerModel
 * @Author: lerry_li
 * @CreateTime: 2021/03/11
 * @Description 生产者消费者模型：使用ReentrantLock和它内部的Condition实现
 */
public class ProducerConsumerModel {
    final static int MAX = 10;
    LinkedList<Integer> queue = new LinkedList<>();


    ReentrantLock lock = new ReentrantLock();
    Condition canProduce = lock.newCondition();
    Condition canConsume = lock.newCondition();

    int readData() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
        return (int) Math.floor(Math.random());
    }

    //producer
    public void produce() throws InterruptedException {
        //检查队列是否已满
        lock.lock();
        //若队列已满，则线程休眠，即生产者暂停生产
        if (queue.size() == MAX) {
            canProduce.await();
            return;
        }
        int data = readData();//1s
        //当队列中有一个消息时，唤醒消费者
        if (queue.size() == 1) {
            canConsume.signalAll();
        }
        queue.add(data);
        lock.unlock();
    }

    //consumer
    public void consume() throws InterruptedException {
        //检查队列是否为空
        lock.lock();
        if (queue.size() == 0) {
            canConsume.await();
            return;
        }
        int data = queue.remove();
        System.out.println("queue-size:" + queue.size());
        //当队列中的消息未满（MAX-1）时，唤醒生产者
        if (queue.size() == MAX - 1) {
            canProduce.signalAll();
        }
        data *= 100;
        lock.unlock();
    }

    public static void main(String[] args) {
        ProducerConsumerModel p = new ProducerConsumerModel();
        //开100个线程生产
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            p.produce();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        //开1个线程消费
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
