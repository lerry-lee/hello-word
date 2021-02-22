package _并发和多线程._synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: _lock实现加锁释放锁
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _lock实现加锁释放锁 {
    Lock lock = new ReentrantLock();

    public synchronized void m1() {
        System.out.println("我是synchronized锁");
    }

    public void m2() {
        lock.lock();
        try {
            System.out.println("我是lock锁");
        } finally {
            lock.unlock();
        }
    }

}
