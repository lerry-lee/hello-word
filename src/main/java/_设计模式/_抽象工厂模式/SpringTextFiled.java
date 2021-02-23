package _设计模式._抽象工厂模式;

/**
 * @ClassName: SpringTextFiled
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：Spring文本框类
 */
public class SpringTextFiled implements TextField{
    @Override
    public void display() {
        System.out.println("显示绿色边框文本框。");
    }
}
