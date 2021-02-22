package _并发和多线程._synchronized._对象锁和类锁;

/**
 * @ClassName: _对象锁之代码块形式
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _对象锁之代码块形式 implements Runnable {

    private static _对象锁之代码块形式 instance = new _对象锁之代码块形式();

    private Object lock = new Object();

    @Override
    public void run() {
        //锁对象使用this或者自定义lock对象
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
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
