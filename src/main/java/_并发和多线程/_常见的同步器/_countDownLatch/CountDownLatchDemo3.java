package _并发和多线程._常见的同步器._countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CountDownLatchDemo3
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description 模拟长跑，5名选手都准备好了，只等裁判员一声令下，所有人同时开始跑步。
 * 当所有人跑到终点后，比赛结束。
 */
public class CountDownLatchDemo3 {
    public static void main(String[] args) throws InterruptedException {
        //1个裁判员
        CountDownLatch begin = new CountDownLatch(1);
        //5个运动员
        CountDownLatch end = new CountDownLatch(5);
        //线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + no + "准备完毕，等待发令枪");
                    try {
                        begin.await();
                        System.out.println("No." + no + "开始跑步了");
                        //模拟跑步的时间
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + no + "跑到终点了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //通知裁判员
                        end.countDown();
                    }
                }
            };
            threadPool.submit(runnable);
        }
        //裁判员检查发令枪...
        Thread.sleep(5000);
        System.out.println("发令枪响！开始跑！");
        begin.countDown();

        end.await();
        System.out.println("所有人到达终点，比赛结束");

        threadPool.shutdown();
    }
}
