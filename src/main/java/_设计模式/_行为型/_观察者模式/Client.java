package _设计模式._行为型._观察者模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description
 */
public class Client {

    public static void main(String[] args) {
        //定义观察目标对象
        AllyControlCenter acc = new ConcreteAllyControlCenter("金庸群侠");

        //定义4个观察者对象
        Observer player1, player2, player3, player4;
        player1 = new Player("杨过");
        acc.join(player1);
        player2 = new Player("令狐冲");
        acc.join(player2);
        player3 = new Player("张无忌");
        acc.join(player3);
        player4 = new Player("段誉");
        acc.join(player4);

        //某成员遭受共计
        player1.beAttacked(acc);
    }

}
