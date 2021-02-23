package _设计模式._简单工厂模式;

/**
 * @ClassName: PieChart
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品类：饼状图类
 */
public class PieChart implements Chart{

    public PieChart() {
        System.out.println("创建饼状图！");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图！");
    }
}
