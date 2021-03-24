package _设计模式._结构型._装饰器模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Component component = new Window();//使用抽象构件定义具体构件window
        Component componentSB = new ScrollBarDecorator(component);//定义使用滚动条装饰后的构件
        componentSB.display();


        //第二次装饰:被装饰了一次之后的对象继续注入到另一个装饰类中
        Component componentBB=new BlackBorderDecorator(componentSB);
        componentBB.display();
    }
}
