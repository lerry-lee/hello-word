package _设计模式._抽象工厂模式;

/**
 * @ClassName: SpringComboBox
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：Spring组合框类
 */
public class SpringComboBox implements ComboBox{
    @Override
    public void display() {
        System.out.println("显示绿色边框组合框。");
    }
}
