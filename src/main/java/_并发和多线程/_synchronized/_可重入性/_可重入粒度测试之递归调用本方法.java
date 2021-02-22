package _并发和多线程._synchronized._可重入性;

/**
 * @ClassName: _可重入粒度测试之递归调用本方法
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _可重入粒度测试之递归调用本方法 {

    int a = 0;

    public static void main(String[] args) {
        _可重入粒度测试之递归调用本方法 instance = new _可重入粒度测试之递归调用本方法();
        instance.method1();
    }

    private synchronized void method1() {
        System.out.println("这是method1,a=" + a);
        if (a == 0) {
            a++;
            method1();
        }
    }
}
