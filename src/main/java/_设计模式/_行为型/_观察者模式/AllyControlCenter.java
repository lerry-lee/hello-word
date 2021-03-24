package _设计模式._行为型._观察者模式;

import java.util.ArrayList;

/**
 * @ClassName: AllyControlCenter
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 目标类：战队控制中心类
 */
public abstract class AllyControlCenter {
    protected String allyName;//战队名称
    protected ArrayList<Observer> players = new ArrayList<>();//定义一个集合用于存放战队成员

    //注册方法
    public void join(Observer observer) {
        System.out.println(observer.getName() + "加入" + allyName + "战队！");
        players.add(observer);
    }

    //注销方法
    public void quit(Observer observer) {
        System.out.println(observer.getName() + "退出" + allyName + "战队！");
        players.remove(observer);
    }

    //声明抽象通知方法
    public abstract void notifyObservers(String name);

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }
}
