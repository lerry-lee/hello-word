package _设计模式._行为型._状态模式._共享状态;

/**
 * @ClassName: State
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description 抽象状态类
 */
abstract class State {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}
