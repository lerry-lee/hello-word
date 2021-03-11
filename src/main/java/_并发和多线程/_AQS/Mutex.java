package _并发和多线程._AQS;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName: Mutex
 * @Author: lerry_li
 * @CreateTime: 2021/03/11
 * @Description 使用AQS实现一个简单的互斥锁
 */
public class Mutex {
    private final Sync sync = new Sync();

    static class Sync extends AbstractQueuedSynchronizer {
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        protected boolean tryRelease(int arg) {
            return compareAndSetState(1, 0);
        }
    }

    public void lock() {
        sync.acquire(0);
    }

    public void unlock() {
        sync.release(0);
    }

}
