package _并发和多线程._多线程编程题;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用线程池和Future类实现多线程对同一个数组累加求和
 * 例如：长度为1000000的数组，简单起见，假设全为1，[1,1,1,...,1],使用多线程对其累加求和
 */
public class _大数组求和 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        _大数组求和 instance = new _大数组求和();
        //--------------模拟一个大数组--------------
        int len = 1000000;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = 1;
        }
        //--------------模拟一个大数组--------------
        instance.doSum(nums);
    }

    //线程池，用于管理线程
    private ThreadPoolExecutor threadPoolExecutor;
    //Future类，用于接受线程返回值
    private List<Future<Long>> futureList;

    public void doSum(int[] nums) throws ExecutionException, InterruptedException {
        //5个线程的线程池
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        //Future类的list
        futureList = new ArrayList<>();

        int len = nums.length;

        //设置分片大小，每gap个数组元素的求和任务交给一个线程处理
        int gap = 1000;
        int start = 0;
        int end = start + gap;
        while (end < len) {
            //提交求和任务，交给线程池，线程池分配线程来执行任务，返回值赋给future对象
            Future<Long> future = threadPoolExecutor.submit(new SumTask(nums, start, end));
            //每个线程执行的结果future对象，将其添加到list中
            futureList.add(future);
            start = end;
            end += gap;
        }
        //最后可能剩下不到一个gap的区间
        futureList.add(threadPoolExecutor.submit(new SumTask(nums, start, len)));

        //关闭线程池
        threadPoolExecutor.shutdown();
        //统计结果
        long res = 0L;
        //把list中所有future对象的值累加即可
        for (Future<Long> future : futureList) {
            res += future.get();
        }
        System.out.println("sum: " + res);
    }

    //执行任务的具体类
    class SumTask implements Callable<Long> {
        //求和的数组
        int[] nums;
        //起始下标
        int start;
        //终止下标
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

}
