package _设计模式._代理模式;

/**
 * @ClassName: Logger
 * @Author: lerry_li
 * @CreateTime: 2021/02/26
 * @Description 业务类：日志记录类
 */
public class Logger {
    public void log(String userId) {
        System.out.println("用户" + userId + "查询次数+1");
    }
}
