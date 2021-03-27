package _并发和多线程._ThreadLocal;

/**
 * @ClassName: Service1
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description
 */
public class Service3 {
    public void process(){
        User user = UserContextHolder.userThreadLocal.get();
        System.out.println("service3:"+user.name);

    }
}
