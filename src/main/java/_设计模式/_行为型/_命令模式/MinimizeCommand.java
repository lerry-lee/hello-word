package _设计模式._行为型._命令模式;

/**
 * @ClassName: MinimizeCommand
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 具体命令类：最小化命令类
 */
public class MinimizeCommand extends Command {

    //维持对请求接受者的调用
    private WindowHandler windowHandler;

    public MinimizeCommand() {
        windowHandler=new WindowHandler();
    }

    //命令执行方法，将调用请求接收者的业务方法
    @Override
    public void execute() {
        windowHandler.minimize();
    }
}
