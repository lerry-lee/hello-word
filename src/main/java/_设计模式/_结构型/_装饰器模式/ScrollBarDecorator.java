package _设计模式._结构型._装饰器模式;

/**
 * @ClassName: ScrollBarDecorator
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体装饰类：滚动条装饰类
 */
public class ScrollBarDecorator extends ComponentDecorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    public void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }
}
