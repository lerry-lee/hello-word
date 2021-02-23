package _设计模式._状态模式._使用环境类实现状态转换;

/**
 * @ClassName: Screen
 * @Author: lerry_li
 * @CreateDate: 2021/02/23
 * @Description 环境类
 *
 * 所有的状态转换操作都由环境类Screen来实现，此时，环境类充当了状态管理器角色。
 * 如果需要增加新的状态，例如“八倍状态类”，需要修改环境类，
 * 这在一定程度上违背了“开闭原则”，但对其他状态类没有任何影响。
 */
public class Screen {
    //枚举所有的状态，currentState表示当前的状态
    private State normalState, largerState, largestState, currentState;

    public Screen() {
        this.normalState = new NormalState();//创建正常状态对象
        this.largerState = new LargerState();//创建二倍放大状态对象
        this.largestState = new LargestState();//创建四倍放大状态对象
        this.currentState = normalState;//设置初始状态
        this.currentState.display();
    }

    //单击事件处理方法，封装了对状态类中业务方法的调用和状态的转换
    public void onClick() {
        if (currentState == normalState) {
            this.setState(largerState);
            currentState.display();
        } else if (currentState == largerState) {
            this.setState(largestState);
            currentState.display();
        } else if (currentState == largestState) {
            this.setState(normalState);
            currentState.display();
        }
    }

    public void setState(State state) {
        this.currentState = state;
    }

}
