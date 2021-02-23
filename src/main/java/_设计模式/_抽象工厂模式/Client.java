package _设计模式._抽象工厂模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        //使用抽象层定义
        SkinFactory factory = (SkinFactory) XMLUtil.getBean();

        Button button = factory.createButton();
        TextField textField = factory.createTextFiled();
        ComboBox comboBox = factory.createComboBox();

        button.display();
        textField.display();
        comboBox.display();
    }
}
