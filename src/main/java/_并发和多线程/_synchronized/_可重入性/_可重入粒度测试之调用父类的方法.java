package _并发和多线程._synchronized._可重入性;

/**
 * @ClassName: _可重入粒度测试之调用父类的方法
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class _可重入粒度测试之调用父类的方法 {
    public synchronized void doSomething() {
        System.out.println("我是父类方法，已加锁");
    }
}

class TestClass extends _可重入粒度测试之调用父类的方法 {
    @Override
    public synchronized void doSomething() {
        System.out.println("我是子类方法，已加锁");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass instance = new TestClass();
        instance.doSomething();
    }
}