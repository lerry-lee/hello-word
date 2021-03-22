package _并发和多线程._多线程编程题;

/**
 * @ClassName: practice2
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */

import java.util.concurrent.CyclicBarrier;
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
public class practice2 {
    static int number = 0;


    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        ReentrantLock lock = new ReentrantLock();
        Condition canT1do=lock.newCondition(),canT2do=lock.newCondition(),canT3do= lock.newCondition();
        Thread t1 = new Thread(new task(lock,1,canT1do,canT2do));
        Thread t2 = new Thread(new task(lock,2,canT2do,canT3do));
        Thread t3 = new Thread(new task(lock,3,canT3do,canT1do));
        t1.start();
        t2.start();
        t3.start();
    }

    static class task implements Runnable {

        private ReentrantLock lock;
        private int id;
        private Condition canIDo;
        private Condition canNextDo;
        private int end=36;

        public task(ReentrantLock lock, int id, Condition canIDo, Condition canNextDo) {
            this.lock = lock;
            this.id = id;
            this.canIDo = canIDo;
            this.canNextDo = canNextDo;
        }

        @Override
        public void run() {

            while(number<=end){
                lock.lock();
                try{
                    int no=number%9;
                    if(no>=id&&no<=id+2){
                        for (int i = 0; i < 2; i++) {
                            number++;
                            System.out.println("线程"+id+": "+number);
                        }
                        canNextDo.signal();
                    }else {
                        canIDo.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }

        }
    }
}
