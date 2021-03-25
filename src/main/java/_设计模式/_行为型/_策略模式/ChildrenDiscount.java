package _设计模式._行为型._策略模式;

/**
 * @ClassName: ChildrenDiscount
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 具体策略类：儿童票折扣类
 */
public class ChildrenDiscount implements Discount{
    @Override
    public double calculate(double price) {
        System.out.println("儿童票：");
        return price-10;
    }
}
