package _设计模式._行为型._命令模式._请求日志;

/**
 * @ClassName: ModifyCommand
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 具体命令：修改命令类
 */
public class ModifyCommand extends Command {
    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute() {
        configOperator.modify(args);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.modify(args);
    }
}
