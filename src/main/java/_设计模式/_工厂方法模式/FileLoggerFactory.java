package _设计模式._工厂方法模式;

/**
 * @ClassName: FileLoggerFactory
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description
 */
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //创建文件日志记录器对象
        Logger logger = new FileLogger();
        //创建文件，代码略
        return logger;
    }
}
