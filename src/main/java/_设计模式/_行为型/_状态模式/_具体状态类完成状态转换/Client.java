package _设计模式._行为型._状态模式._具体状态类完成状态转换;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Account account = new Account("小明", 0.0);
        account.deposit(1000);
        account.withdraw(2000);
        account.deposit(3000);
        account.withdraw(4000);
        account.withdraw(1000);
        account.computeInterest();
    }
}
