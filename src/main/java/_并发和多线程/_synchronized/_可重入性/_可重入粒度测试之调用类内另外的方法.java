package _并发和多线程._synchronized._可重入性;

/**
 * @ClassName: _可重入粒度测试之调用类内另外的方法
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _可重入粒度测试之调用类内另外的方法 {
    public synchronized void method1() {
        System.out.println("我是method1");
        method2();
    }

    public synchronized void method2() {
        System.out.println("我是method2");
    }

    public static void main(String[] args) {
        _可重入粒度测试之调用类内另外的方法 instance = new _可重入粒度测试之调用类内另外的方法();
        instance.method1();
    }
}
