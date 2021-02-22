package _并发和多线程._synchronized._可重入性;

/**
 * @ClassName: _可重入粒度测试之调用其他类的方法
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _可重入粒度测试之调用其他类的方法 implements Runnable {

    private static _可重入粒度测试之调用其他类的方法 instance = new _可重入粒度测试之调用其他类的方法();

    Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        B instance = new B();
//        instance.mB(lock);
        instance.mb();
    }
}

class A {
    public void mA(Object lock) {
        synchronized (lock) {
            System.out.println("我是加锁的mA。" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            B b = new B();
            b.mB(lock);
        }
    }

    public synchronized void ma(){
        System.out.println("我是加锁的ma。" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B b = new B();
        b.mb();
    }
}

class B {

    public synchronized void mb(){
        System.out.println("我是加锁的mb。" + Thread.currentThread().getName());
        A a = new A();
        a.ma();
    }

    public void mB(Object lock) {
        synchronized (lock) {
            System.out.println("我是加锁的mB。" + Thread.currentThread().getName());
            A a = new A();
            a.mA(lock);
        }
    }
}
