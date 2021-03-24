package _设计模式._结构型._装饰器模式;

/**
 * @ClassName: ComponentDecorator
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 抽象装饰类
 */
public class ComponentDecorator extends Component{

    private Component component;//维持对抽象构件类型对象的引用

    //注入抽象构建类型的对象
    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
