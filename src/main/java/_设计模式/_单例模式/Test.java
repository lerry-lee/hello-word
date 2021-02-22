package _设计模式._单例模式;

/**
 * @ClassName: Test
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        //静态内部类实现
        SingletonStaticInnerClass s1= SingletonStaticInnerClass.getUniqueInstance();
        SingletonStaticInnerClass s2= SingletonStaticInnerClass.getUniqueInstance();
        System.out.println(s1==s2);
        //双重校验锁
        SingletonDoubleVerifyLock s3= SingletonDoubleVerifyLock.getUniqueInstance();
        SingletonDoubleVerifyLock s4= SingletonDoubleVerifyLock.getUniqueInstance();
        System.out.println(s3==s4);
        //懒汉式-线程安全
        SingletonLazy2 s5=SingletonLazy2.getUniqueInstance();
        SingletonLazy2 s6=SingletonLazy2.getUniqueInstance();
        System.out.println(s5==s6);
    }
}
