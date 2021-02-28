package _设计模式._行为型._状态模式._共享状态;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Switch s1,s2;
        s1=new Switch("开关1");
        s2=new Switch("开关2");

        s1.on();
        s2.off();
        s1.off();
    }
}
