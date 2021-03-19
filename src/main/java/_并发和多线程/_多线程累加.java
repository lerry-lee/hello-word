package _并发和多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName: _多线程累加
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description 使用线程池和Future类实现多线程对同一个数组累加问题
 */
public class _多线程累加 {
    //线程池
    private ThreadPoolExecutor threadPoolExecutor;
    //Future类
    private List<Future<Long>> futureList;

    public void doSum() throws ExecutionException, InterruptedException {
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        futureList = new ArrayList<>();
        int len = 10000;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = 1;
        }
        int gap = 1000;
        int start = 0;
        int end = start + gap;
        while (end < len) {
            Future<Long> future = threadPoolExecutor.submit(new SumTask(nums, start, end));
            futureList.add(future);
            start = end;
            end += gap;
        }
        //最后可能剩下不到一个gap的区间
        futureList.add(threadPoolExecutor.submit(new SumTask(nums, start, len)));

        //关闭线程池
        threadPoolExecutor.shutdown();
        //统计结果
        long res = 0l;
        for (Future<Long> future : futureList) {
            res += future.get();
            System.out.println(res);
        }
//        System.out.println(res);
    }

    class SumTask implements Callable<Long> {
        int[] nums;
        int start;
        int end;

        public SumTask(int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0L;
            for (int i = start; i < end; i++) {
                sum += nums[i];
            }
//            //睡眠1s
//            Thread.sleep(1000);
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        _多线程累加 instance = new _多线程累加();
        instance.doSum();
    }
}
