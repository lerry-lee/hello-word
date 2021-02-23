package _设计模式._抽象工厂模式;

/**
 * @ClassName: SkinFactory
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 抽象工厂：界面皮肤工厂接口
 */
public interface SkinFactory {
    public Button createButton();

    public TextField createTextFiled();

    public ComboBox createComboBox();
}
