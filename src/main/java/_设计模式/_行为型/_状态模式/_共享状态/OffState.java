package _设计模式._行为型._状态模式._共享状态;

/**
 * @ClassName: OffState
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description
 */
public class OffState extends State{
    @Override
    public void on(Switch s) {
        System.out.println("打开！");
        s.setState(Switch.getState("on"));
    }

    @Override
    public void off(Switch s) {
        System.out.println("已经关闭！");
    }
}
