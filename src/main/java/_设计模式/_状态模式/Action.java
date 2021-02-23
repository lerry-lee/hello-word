package _设计模式._状态模式;

/**
 * @ClassName: Action
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 动作
 */
public interface Action {
    //投入一个硬币
    void insertCoin();

    //退回一个硬币
    void ejectCoin();

    //转动曲柄
    void turnCrank();

    //发放糖果
    void dispense();
}
