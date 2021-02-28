package _设计模式._创建型._简单工厂模式;

/**
 * @ClassName: HistogramChart
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品类：柱状图类
 */
public class HistogramChart implements Chart{

    public HistogramChart(){
        System.out.println("创建柱状图！");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }
}
