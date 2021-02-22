package _设计模式._单例模式;

/**
 * @ClassName: SingletonDoubleVerifyLock
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 双重校验锁-线程安全
 */
public class SingletonDoubleVerifyLock {
    private volatile static SingletonDoubleVerifyLock uniqueInstance;

    private SingletonDoubleVerifyLock(){}

    public static SingletonDoubleVerifyLock getUniqueInstance(){
        if(uniqueInstance==null){
            synchronized (SingletonDoubleVerifyLock.class){
                if(uniqueInstance==null){
                    uniqueInstance=new SingletonDoubleVerifyLock();
                }
            }
        }
        return uniqueInstance;
    }
}
