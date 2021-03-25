package _设计模式._行为型._命令模式;

/**
 * @ClassName: FunctionButton
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 请求发送者：功能键类
 */
public class FunctionButton {
    //功能键名称
    private String name;
    //维持一个抽象命令对象的引用
    private Command command;


    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Command getCommand() {
        return command;
    }

    //为功能键注入命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //发送请求的方法
    public void onClick() {
        System.out.print("点击功能键：");
        command.execute();
    }
}
