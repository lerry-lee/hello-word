package _并发和多线程._ThreadLocal;

/**
 * @ClassName: UserContextHolder
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description
 */
public class UserContextHolder {
    public static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();
}
