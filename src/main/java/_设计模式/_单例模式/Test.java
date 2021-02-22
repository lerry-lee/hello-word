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
        Singleton s1=Singleton.instance;
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);
        //懒汉模式
        Singleton2 s3=Singleton2.getInstance();
        Singleton2 s4=Singleton2.getInstance();
        System.out.println(s3==s4);
    }
}
