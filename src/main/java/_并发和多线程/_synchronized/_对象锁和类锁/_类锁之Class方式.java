package _并发和多线程._synchronized._对象锁和类锁;

/**
 * @ClassName: _类锁之Class方式
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _类锁之Class方式 implements Runnable{

    private static _类锁之Class方式 instance1=new _类锁之Class方式();
    private static _类锁之Class方式 instance2=new _类锁之Class方式();

    @Override
    public void run() {
        method();
    }

    private void method() {
        synchronized(_类锁之Class方式.class){
            System.out.println("我是类锁的Class形式。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }
}
