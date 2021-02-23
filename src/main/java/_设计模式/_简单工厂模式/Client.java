package _设计模式._简单工厂模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Chart chart = ChartFactory.getChart("histogram");//通过静态工厂方法创建产品
        chart.display();
    }
}
