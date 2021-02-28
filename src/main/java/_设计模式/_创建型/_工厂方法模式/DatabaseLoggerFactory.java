package _设计模式._创建型._工厂方法模式;

/**
 * @ClassName: DatabaseLoggerFactory
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description
 */
public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //连接数据库，代码略
        //创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码略
        return logger;
    }
}
