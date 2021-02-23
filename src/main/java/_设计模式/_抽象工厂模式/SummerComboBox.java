package _设计模式._抽象工厂模式;

/**
 * @ClassName: SummerComboBox
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：Summer组合框类
 */
public class SummerComboBox implements ComboBox{
    @Override
    public void display() {
        System.out.println("显示蓝色边框组合框。");
    }
}
