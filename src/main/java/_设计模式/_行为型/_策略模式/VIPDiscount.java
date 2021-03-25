package _设计模式._行为型._策略模式;

/**
 * @ClassName: VIPDiscount
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 具体策略类：VIP会员票折扣类
 */
public class VIPDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}
