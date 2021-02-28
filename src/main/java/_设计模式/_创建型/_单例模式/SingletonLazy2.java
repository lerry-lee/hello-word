package _设计模式._创建型._单例模式;

/**
 * @ClassName: SingletonLazy2
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 单例模式之懒汉式-线程安全
 */
public class SingletonLazy2 {
    private SingletonLazy2() {
    }

    private static SingletonLazy2 uniqueInstance;

    public static synchronized SingletonLazy2 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonLazy2();
        }
        return uniqueInstance;
    }
}
