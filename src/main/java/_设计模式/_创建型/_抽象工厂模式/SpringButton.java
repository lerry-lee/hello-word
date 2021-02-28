package _设计模式._创建型._抽象工厂模式;

/**
 * @ClassName: SpringButton
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：Spring按钮类
 */
public class SpringButton implements Button{
    @Override
    public void display() {
        System.out.println("显示浅绿色按钮。");
    }
}
