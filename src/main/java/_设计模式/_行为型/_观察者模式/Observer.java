package _设计模式._行为型._观察者模式;

/**
 * @ClassName: Observer
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 抽象观察类
 */
public interface Observer {
    public String getName();
    public void setName(String name);
    public void help();
    public void beAttacked(AllyControlCenter acc);
}
