package _并发和多线程._ThreadLocal;

/**
 * @ClassName: ThreadLocalDemo2
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description 线程池+ThreadLocal 同一线程内不同方法共享全局变量
 */
public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        new Service1().process();
    }
}
