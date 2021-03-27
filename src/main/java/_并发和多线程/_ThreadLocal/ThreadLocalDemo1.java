package _并发和多线程._ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ThreadLocalDemo1
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description 线程池+ThreadLocal 给每个线程分配自己的对象
 */
public class ThreadLocalDemo1 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String data = new ThreadLocalDemo1().date(finalI);
                    System.out.println(data);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {
        Date data = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal2.get();
        return dateFormat.format(data);
    }
}
