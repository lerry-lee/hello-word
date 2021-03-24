package _设计模式._结构型._装饰器模式;

/**
 * @ClassName: ListBox
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体构件类：列表框类
 */
public class ListBox extends Component{
    @Override
    public void display() {
        System.out.println("显示列表框");
    }
}
