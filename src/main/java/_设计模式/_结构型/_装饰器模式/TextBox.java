package _设计模式._结构型._装饰器模式;

/**
 * @ClassName: TextBox
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体构建类：文本框类
 */
public class TextBox extends Component{
    @Override
    public void display() {
        System.out.println("显示文本框！");
    }
}
