package _设计模式._结构型._装饰器模式;

/**
 * @ClassName: Window
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体构建类：窗体类
 */
public class Window extends Component{
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }
}
