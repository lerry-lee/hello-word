package _设计模式._状态模式._共享状态;

/**
 * @ClassName: Switch
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description 环境类：开关类
 */
public class Switch {
    //定义三个静态的状态对象
    private static State state, onState, offState;

    private String name;

    public Switch(String name) {
        this.name = name;
        onState = new OnState();
        offState = new OffState();
        this.state = onState;
    }

    public static State getState(String type) {
        if (type.equalsIgnoreCase("on")) {
            return onState;
        }
        return offState;
    }

    public void setState(State state) {
        this.state = state;
    }

    //打开开关
    public void on() {
        System.out.print(name);
        state.on(this);
    }

    //关闭开关
    public void off() {
        System.out.print(name);
        state.off(this);
    }
}
