package _设计模式._抽象工厂模式;

/**
 * @ClassName: SummerButton
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：Summer按钮类
 */
public class SummerButton implements Button{
    @Override
    public void display() {
        System.out.println("显示浅蓝色按钮。");
    }
}
