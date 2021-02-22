package _并发和多线程._synchronized._常见面试题;

/**
 * @ClassName: _同时访问静态synchronized和非静态synchronized方法
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _同时访问静态synchronized和非静态synchronized方法 implements Runnable {
    private static _同时访问静态synchronized和非静态synchronized方法 instance = new _同时访问静态synchronized和非静态synchronized方法();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized static void method1() {
        System.out.println("我是static加锁的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2() {
        System.out.println("我是非static加锁的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }
}
