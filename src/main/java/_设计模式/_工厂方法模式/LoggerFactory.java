package _设计模式._工厂方法模式;

/**
 * @ClassName: LoggerFactory
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 抽象工厂：日志记录器工厂接口
 */
public interface LoggerFactory {
    public Logger createLogger();
}
