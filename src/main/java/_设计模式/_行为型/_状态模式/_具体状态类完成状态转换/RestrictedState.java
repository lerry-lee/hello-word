package _设计模式._行为型._状态模式._具体状态类完成状态转换;

/**
 * @ClassName: RestrictedState
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description 具体状态类：受限状态
 * 条件：
 * 账户余额<-2000
 */
public class RestrictedState extends AccountState {


    public RestrictedState(AccountState state) {
        this.account = state.account;
    }

    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    @Override
    public void stateCheck() {
        if (account.getBalance() > 0) {
            account.setState(new NormalState(this));
        } else if (account.getBalance() > -2000) {
            account.setState(new OverdraftState(this));
        }
    }
}
