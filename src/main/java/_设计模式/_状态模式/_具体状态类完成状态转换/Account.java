package _设计模式._状态模式._具体状态类完成状态转换;


/**
 * @ClassName: Account
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description 环境类
 */
public class Account {
    private AccountState state;//维持一个对抽象状态对象的引用
    private String owner;//开户名
    private double balance = 0;//账户余额

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.state = new NormalState(this);
        System.out.println(owner + "开户，初始金额为" + balance);
        System.out.println("-----------------------------------------");
    }

    //存款操作
    public void deposit(double amount) {
        System.out.println(owner + "存款" + amount);
        state.deposit(amount);
        System.out.println("现在余额为" + balance);
        System.out.println("现在账户状态为" + state.getClass().getName());
        System.out.println("-----------------------------------------");
    }

    //取款操作
    public void withdraw(double amount) {
        System.out.println(owner + "取款" + amount);
        state.withdraw(amount);
        System.out.println("现在余额为" + balance);
        System.out.println("现在账户状态为" + state.getClass().getName());
        System.out.println("-----------------------------------------");
    }

    //计算利息
    public void computeInterest() {
        state.computeInterest();
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
