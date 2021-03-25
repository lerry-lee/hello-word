package _设计模式._行为型._命令模式;

/**
 * @ClassName: HelpCommand
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 具体命令类：帮助命令类
 */
public class HelpCommand extends Command {

    //维持对请求接收者的引用
    private HelpHandler helpHandler;

    public HelpCommand() {
        helpHandler = new HelpHandler();
    }

    //命令执行方法，将调用请求接收者的业务方法
    @Override
    public void execute() {
        helpHandler.display();
    }
}
