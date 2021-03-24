package _设计模式._结构型._外观模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        EncryptFacade facade = new EncryptFacade();
        facade.FileEncrypt("hello", "des.txt");

        //针对抽象外观类编程
        AbstractEncryptFacade abstractEncryptFacade=new NewEncryptFacade();
        abstractEncryptFacade.FileEncrypt("olleh","des,txt");
    }
}
