package _并发和多线程._synchronized;

/**
 * @ClassName: Demo
 * @Author: lerry_li
 * @CreateTime: 2021/02/25
 * @Description
 */
public class Demo implements Runnable {

    static Demo instance = new Demo();

    static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        Thread t3 = new Thread(instance);
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 2; j++) {
                if(i==5){
                    break;
                }
                System.out.println("ABC(" + Thread.currentThread().getName() + ")");
                i++;
            }
        }
    }
}
