package _设计模式._创建型._抽象工厂模式;

/**
 * @ClassName: SummerTextFiled
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体产品：Summer文本框类
 */
public class SummerTextFiled implements TextField{
    @Override
    public void display() {
        System.out.println("显示蓝色边框文本框。");
    }
}
