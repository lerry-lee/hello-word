package _设计模式._行为型._观察者模式;

/**
 * @ClassName: ConcreteAllyControlCenter
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体目标类：具体战队控制中心类
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "战队组建成功！");
        System.out.println("--------------------------------");
        this.allyName = allyName;
    }

    @Override
    public void notifyObservers(String name) {
        System.out.println(allyName + "战队紧急通知，盟友" + name + "遭受敌人攻击！");
        //遍历观察者集合，调用每一个盟友（自己除外）的支援方法
        for (Observer observer : players) {
            if (!observer.getName().equals(name)) {
                observer.help();
            }
        }
    }
}
