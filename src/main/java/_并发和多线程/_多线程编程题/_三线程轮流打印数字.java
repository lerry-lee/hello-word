package _并发和多线程._多线程编程题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 问题：写一段java多线程代码，完成如下逻辑，同时启动3个线程从1开始打印递增数字，每次每个线程打印3次，打印到36程序结束，输出如下：

 线程1：1
 线程1：2
 线程1：3

 线程2：4
 线程2：5
 线程2：6

 线程3：7
 线程3：8
 线程3：9

 线程1：10
 线程1：11
 线程1：12

 ......

 线程3：34
 线程3：35
 线程3：36
 */
public class _三线程轮流打印数字 {
    public static void main(String[] args) {
        //互斥锁
        ReentrantLock lock = new ReentrantLock();
        //条件变量
        Condition condition = lock.newCondition();
        //启动3个线程，并赋予它们线程号1,2,3
        new Thread(new Task(lock, condition, 1)).start();
        new Thread(new Task(lock, condition, 2)).start();
        new Thread(new Task(lock, condition, 3)).start();
    }

    //当前数字（要打印的）
    static int curNumber = 1;

    //具体的任务类
    static class Task implements Runnable {
        //互斥锁，从构造函数中传入，使用同一把
        private ReentrantLock lock;
        //打印到多少停止
        private int endNumber = 36;
        //线程号
        private int threadId;
        //条件变量，控制当前打印的线程是哪个
        private Condition condition;

        //构造函数
        public Task(ReentrantLock lock, Condition condition, int threadId) {
            this.lock = lock;
            this.threadId = threadId;
            this.condition = condition;
        }

        @Override
        public void run() {
            //若当前数字<=终止数字，就继续打印
            while (curNumber <= endNumber) {
                lock.lock();
                try {
                    //找规律，9个一循环
                    // 线程1打印的数字模9的余数为：1,2,3
                    // 线程2打印的数字模9的余数为：4,5,6
                    // 线程3打印的数字模9的余数为：7,8,0
                    int no = curNumber % 9;
                    //若当前线程号对应上了当前的数字，那么就由当前线程来打印当前的数字
                    if (checkNumberAndThreadId(no, threadId)) {
//                        for (int i = 0; i < 3; i++) {
                        System.out.println("线程" + threadId + ": " + curNumber);
                        curNumber++;
//                        }
                        //打印完之后，唤醒其他线程
                        condition.signalAll();
                    } else {
                        //否则，即当前线程号和当前数字不对应，那么当前线程挂起（等待）
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public boolean checkNumberAndThreadId(int number, int id) {
            return ((number == 1 || number == 2 || number == 3) && id == 1) || ((number == 4 || number == 5 || number == 6) && id == 2) || ((number == 7 || number == 8 || number == 0) && id == 3);
        }
    }
}
