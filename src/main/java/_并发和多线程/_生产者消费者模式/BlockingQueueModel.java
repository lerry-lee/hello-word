package _并发和多线程._生产者消费者模式;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName: BlockingQueueModel
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description TODO 生产者消费者模型：使用BlockingQueue实现
 */
public class BlockingQueueModel {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Apple> queue = new ArrayBlockingQueue<Apple>(5);

        //开10个线程去生产
        for (int i = 0; i < 10; i++) {
            Apple apple = new Apple(i);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Producer<Apple> producer = new Producer<Apple>(queue);
                    try {
                        producer.produce(apple);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //开1个线程去消费
        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Consumer<Apple> consumer = new Consumer<Apple>(queue);
                    while (true){
                        try {
                            consumer.consume();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    /**
     * Apple：生产和消费的对象
     */
    static class Apple {
        private int id;

        public Apple(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "id=" + id +
                    '}';
        }
    }

    /**
     * 生产者
     * @param <T>
     */
    static class Producer<T> {
        BlockingQueue<T> queue;

        public Producer(BlockingQueue<T> queue) {
            this.queue = queue;
        }

        //生产
        public void produce(T e) throws InterruptedException {
            queue.put(e);
            System.out.println("正在生产：" + e.toString());
//            //睡眠1s
//            Thread.sleep(1);
        }

    }

    static class Consumer<T> {
        BlockingQueue<T> queue;

        public Consumer(BlockingQueue<T> queue) {
            this.queue = queue;
        }

        //消费
        public void consume() throws InterruptedException {
            T t = queue.take();
            System.out.println("正在消费：" + t.toString());
            //睡眠1s
            Thread.sleep(1);
        }
    }
}
