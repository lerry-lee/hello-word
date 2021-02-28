package _设计模式._行为型._状态模式._具体状态类完成状态转换;

/**
 * @ClassName: AccountState
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description 抽象状态类
 */
abstract class AccountState {
    protected Account account;
    //存款
    public abstract void deposit(double amount);
    //取款
    public abstract void withdraw(double amount);
    //计算利息
    public abstract void computeInterest();
    //检查状态是否需要转移
    public abstract void stateCheck();
}
