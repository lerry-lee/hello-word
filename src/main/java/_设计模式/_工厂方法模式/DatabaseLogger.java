package _设计模式._工厂方法模式;

/**
 * @ClassName: DatabaseLogger
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：数据库日志记录器
 */
public class DatabaseLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录。");
    }
}
