package _设计模式._创建型._单例模式;

/**
 * @ClassName: SingletonStaticInnerClass
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 静态内部类实现-线程安全+延迟初始化
 */
public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass() {
    }

    private static class SingletonHolder {
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

}
