package _设计模式._工厂方法模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        LoggerFactory factory = new FileLoggerFactory();//引入配置文件实现
        Logger logger = factory.createLogger();
        logger.writeLog();
    }
}
