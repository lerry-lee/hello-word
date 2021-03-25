package _设计模式._行为型._命令模式;

import java.util.ArrayList;

/**
 * @ClassName: FBSettingWindow
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 功能键设置窗口类
 */
public class FBSettingWindow {
    //窗口变体
    private String title;
    //定义一个ArrayList来存储所有功能键
    private ArrayList<FunctionButton> functionButtons = new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    //添加功能键
    public void addFunctionButton(FunctionButton fb) {
        functionButtons.add(fb);
    }

    //删除功能键
    public void removeFunctionButton(FunctionButton fb) {
        functionButtons.remove(fb);
    }

    //显示窗口及功能键
    public void display() {
        System.out.println("显示窗口：" + title);
        System.out.println("显示功能键：");
        for (FunctionButton button : functionButtons) {
            System.out.println(button.getName());
        }
        System.out.println("------------------------------------");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
