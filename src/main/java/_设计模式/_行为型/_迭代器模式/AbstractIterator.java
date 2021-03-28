package _设计模式._行为型._迭代器模式;

/**
 * @ClassName: AbstractIterator
 * @Author: lerry_li
 * @CreateTime: 2021/03/28
 * @Description 抽象迭代器
 */
public interface AbstractIterator {
    void next();//移至下一个元素
    boolean isLast();//判断是否为最后一个元素
    void previous();//移至上一个元素
    boolean isFirst();//是否为第一个元素
    Object getNextItem();//获取下一个元素
    Object getPreviousItem();//获取上一个元素
}
