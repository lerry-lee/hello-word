package _设计模式._单例模式;

/**
 * @ClassName: Singleton
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 单例模式之饿汉模式
 */
public class Singleton {
    //1.私有化构造方法，不允许外部直接创建对象
    private Singleton() {

    }

    //2.创建类的唯一实例
    static Singleton instance = new Singleton();

    //3.提供一个用于获取实例的方法
    public static Singleton getInstance() {
        return instance;
    }
}
