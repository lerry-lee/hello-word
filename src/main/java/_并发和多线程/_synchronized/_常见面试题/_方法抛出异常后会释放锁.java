package _并发和多线程._synchronized._常见面试题;

/**
 * @ClassName: _方法抛出异常后会释放锁
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 展示不抛出异常和抛出异常后的对比
 * 一旦抛出了异常，第二个线程会立即进入同步方法，意味着锁已经释放(JVM帮助释放)
 */
public class _方法抛出异常后会释放锁 implements Runnable {
    private static _方法抛出异常后会释放锁 instance = new _方法抛出异常后会释放锁();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1() {
        System.out.println("我是加锁抛异常的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
//        System.out.println(Thread.currentThread().getName() + "运行结束");
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
