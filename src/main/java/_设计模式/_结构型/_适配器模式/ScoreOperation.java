package _设计模式._结构型._适配器模式;

/**
 * @ClassName: ScoreOperation
 * @Author: lerry_li
 * @CreateDate: 2021/02/28
 * @Description 目标接口：抽象成绩操作类
 */
public interface ScoreOperation {
    public void sort(int[] array);//成绩排序

    public int search(int[] array, int key);//成绩查询
}
