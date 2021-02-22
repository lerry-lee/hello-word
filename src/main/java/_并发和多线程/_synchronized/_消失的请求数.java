package _并发和多线程._synchronized;

/**
 * @ClassName: _消失的请求数
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 两个线程同时i++，最后结果会比预计的少
 * 原因：
 * i++，实际包含了3个动作：
 * 1）读取i
 * 2）将i+1
 * 3）将i的值写入到内存中
 */
public class _消失的请求数 implements Runnable {

    private static _消失的请求数 instance = new _消失的请求数();

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        //join()表示线程执行完成后才会执行下一行代码
        t1.join();
        t2.join();
        //预期i为100000*2=200000，结果应该是小于该值
        System.out.println(i);
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }
}
