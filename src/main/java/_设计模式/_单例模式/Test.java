package _设计模式._单例模式;

/**
 * @ClassName: Test
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        //饿汉模式
        SingletonHungry s1= SingletonHungry.instance;
        SingletonHungry s2= SingletonHungry.getInstance();
        System.out.println(s1==s2);
        //懒汉模式
        SingletonLazy s3= SingletonLazy.getInstance();
        SingletonLazy s4= SingletonLazy.getInstance();
        System.out.println(s3==s4);
    }
}
