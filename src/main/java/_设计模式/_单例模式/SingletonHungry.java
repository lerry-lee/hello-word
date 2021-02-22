package _设计模式._单例模式;

/**
 * @ClassName: Singleton
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 单例模式之饿汉式-线程安全
 */
public class SingletonHungry {
    //1.私有化构造方法，不允许外部直接创建对象
    private SingletonHungry() {

    }

    //2.创建类的唯一实例
    static SingletonHungry instance = new SingletonHungry();

    //3.提供一个用于获取实例的方法
    public static SingletonHungry getInstance() {
        return instance;
    }
}
