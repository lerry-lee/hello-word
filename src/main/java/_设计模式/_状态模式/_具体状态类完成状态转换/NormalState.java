package _设计模式._状态模式._具体状态类完成状态转换;

/**
 * @ClassName: NormalState
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description 具体状态类：正常状态
 * 条件：
 * 账户余额>0
 */
public class NormalState extends AccountState {

    //构造函数 初始化
    public NormalState(Account account) {
        this.account = account;
    }

    //构造函数 状态转移
    public NormalState(AccountState accountState) {
        this.account = accountState.account;
    }

    //存款
    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    //存款
    @Override
    public void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }

    //计算利息
    @Override
    public void computeInterest() {
        System.out.println("正常状态，无须支付利息！");
    }

    //检查状态转移
    @Override
    public void stateCheck() {
        if (account.getBalance() > -2000 && account.getBalance() <= 0) {
            account.setState(new OverdraftState(this));
        } else if (account.getBalance() == -2000) {
            account.setState(new RestrictedState(this));
        } else if (account.getBalance() < -2000) {
            System.out.println("操作受限！");
        }
    }
}
