package _并发和多线程._ThreadLocal;

/**
 * @ClassName: Service1
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description
 */
public class Service1 {
    public void process(){
        User user=new User("小明");
        UserContextHolder.userThreadLocal.set(user);
        new Service2().process();
    }
}
