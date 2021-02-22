package _设计模式._单例模式;

/**
 * @ClassName: Singleton2
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 单例模式之懒汉式-线程不安全
 */
public class SingletonLazy {
    //1.私有化构造方法
    private SingletonLazy() {
    }

    //2.创建类的唯一实例，使用private static修饰，只声明
    private static SingletonLazy instance;

    //3.提供一个用于获取实例的方法，使用public static修饰
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
