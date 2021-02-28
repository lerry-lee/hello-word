package _设计模式._结构型._适配器模式;

/**
 * @ClassName: OperationAdapter
 * @Author: lerry_li
 * @CreateDate: 2021/02/28
 * @Description 适配器：操作适配器类
 */
public class OperationAdapter implements ScoreOperation {

    private QuickSort quickSort;//定义适配者对象

    private BinarySearch binarySearch;//定义适配者对象

    public OperationAdapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    @Override
    public void sort(int[] array) {
        quickSort.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return binarySearch.search(array, key);
    }
}
