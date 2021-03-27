package _并发和多线程._ThreadLocal;

import java.text.SimpleDateFormat;

/**
 * @ClassName: ThreadSafeFormatter
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description
 */
public class ThreadSafeFormatter {
    //匿名内部类写法
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };
    //lambda表达式写法
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal2 =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
}
