package _设计模式._行为型._策略模式;

/**
 * @ClassName: StudentDiscount
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 具体策略类：学生票折扣类
 */
public class StudentDiscount implements Discount{

    @Override
    public double calculate(double price) {
        System.out.println("学生票：");
        return price*0.8;
    }
}
