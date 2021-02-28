package _设计模式._行为型._状态模式._使用环境类实现状态转换;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.onClick();
        screen.onClick();
        screen.onClick();
    }
}
