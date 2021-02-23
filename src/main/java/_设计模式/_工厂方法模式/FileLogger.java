package _设计模式._工厂方法模式;

/**
 * @ClassName: FileLogger
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：文件日志记录器
 */
public class FileLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("文件日志记录。");
    }
}
