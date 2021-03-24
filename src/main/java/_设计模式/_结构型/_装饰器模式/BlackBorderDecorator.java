package _设计模式._结构型._装饰器模式;

/**
 * @ClassName: BlackBorderDecorator
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体装饰类：黑色边框装饰类
 */
public class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }
}
