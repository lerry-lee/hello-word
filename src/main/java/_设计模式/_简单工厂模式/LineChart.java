package _设计模式._简单工厂模式;

/**
 * @ClassName: LineChart
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品类：折线图类
 */
public class LineChart implements Chart{
    public LineChart() {
        System.out.println("创建折线图！");
    }

    @Override
    public void display() {
        System.out.println("显示折线图！");
    }
}
