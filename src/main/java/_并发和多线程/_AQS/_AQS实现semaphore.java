package _并发和多线程._AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName: _AQS实现semaphore
 * @Author: lerry_li
 * @CreateTime: 2021/03/11
 * @Description AQS实现信号量
 */
public class _AQS实现semaphore {
    static class Semaphore extends AbstractQueuedSynchronizer {
        //设置最大并发量，即最多有多少个线程可以访问共享资源
        public Semaphore(int permits) {
            //state表示当前还有多少个线程可以访问共享资源
            // state初始值为最大并发量
            setState(permits);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            //获取当前可用的state值
            int available = getState();
            //如果为0，说明当前已经达到最大并发量了，不能再有线程进入临界区了
            if (available == 0) {
                return -1;
            }
            //否则，计算剩余的可用量
            int left = available - 1;
            if (compareAndSetState(available, left)) {
                return left;
            }
            return -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            //获取当前可用的state值
            int available = getState();
            //释放，可用量+1
            return compareAndSetState(available, available + 1);
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        //开1000个线程，打印'go'
        //用semaphore控制并发量，结果每次只能有3个线程打印'go'
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    semaphore.acquireShared(0);
                    try {
                        System.out.println("go");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.releaseShared(0);
                }
            }).start();
        }
    }
}
