package _设计模式._行为型._命令模式._请求日志;

import java.io.Serializable;

/**
 * @ClassName: Command
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 抽象命令类：由于需要将命令对象写入文件，因此它实现了Serializable接口
 */
public abstract class Command implements Serializable {
    //命令名称
    protected String name;
    //命令参数
    protected String args;
    //维持对接收者对象的引用
    protected ConfigOperator configOperator;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public ConfigOperator getConfigOperator() {
        return configOperator;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;
    }

    //声明两个抽象的执行方法execute()
    public abstract void execute();

    public abstract void execute(String args);
}
