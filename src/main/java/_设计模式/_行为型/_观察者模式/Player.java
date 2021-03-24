package _设计模式._行为型._观察者模式;

/**
 * @ClassName: Player
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体观察者类：战队成员类
 */
public class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("坚持住，" + name + "来救你！");
    }

    @Override
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(name + "被攻击！");
        acc.notifyObservers(name);
    }
}
