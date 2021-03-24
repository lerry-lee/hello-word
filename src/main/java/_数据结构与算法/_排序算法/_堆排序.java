package _数据结构与算法._排序算法;

import java.util.Arrays;

/**
 * @ClassName: _堆排序
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description
 */
public class _堆排序 {

    public static void main(String[] args) {
        _堆排序 instance = new _堆排序();
        int[] array = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        instance.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void heapSort(int[] array) {
        //1.把无序数组构建成二叉堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        //2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶
        for (int i = array.length - 1; i >= 0; i--) {
            //最后一个元素和第一个元素进行交换
            swap(array, 0, i);
            //下沉调整最大堆
            downAdjust(array, 0, i);
        }
    }

    public void downAdjust(int[] array, int parentIndex, int length) {
        //temp保存父节点，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;//左孩子的下标
        while (childIndex < length) {
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
