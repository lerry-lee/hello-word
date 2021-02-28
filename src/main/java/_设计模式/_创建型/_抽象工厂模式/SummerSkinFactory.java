package _设计模式._创建型._抽象工厂模式;

/**
 * @ClassName: SummerSkinFactory
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description 具体工厂：Summer皮肤工厂
 */
public class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextFiled() {
        return new SummerTextFiled();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
