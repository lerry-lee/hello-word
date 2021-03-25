package _设计模式._行为型._策略模式;

/**
 * @ClassName: Discount
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 抽象策略类：折扣类
 */
public interface Discount {
    public double calculate(double price);
}
