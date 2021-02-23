package _设计模式._抽象工厂模式;

/**
 * @ClassName: SpringSkinFactory
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体工厂：Spring皮肤工厂
 */
public class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextFiled() {
        return new SpringTextFiled();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
