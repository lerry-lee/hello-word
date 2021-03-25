package _设计模式._行为型._命令模式._请求日志;

/**
 * @ClassName: InsertCommand
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 具体命令：增加命令类
 */
public class InsertCommand extends Command {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute() {
        configOperator.insert(this.args);
    }

    @Override
    public void execute(String args) {
        this.args=args;
        configOperator.insert(this.args);
    }
}
