package _设计模式._结构型._适配器模式;

import java.util.Random;

/**
 * @ClassName: QuickSort
 * @Author: lerry_li
 * @CreateDate: 2021/02/28
 * @Description 适配者：快速排序类
 */
public class QuickSort {
    public void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int l, int r) {
        if (l < r) {
            int p = partition(array, l, r);
            sort(array, l, p - 1);
            sort(array, p + 1, r);
        }
    }

    public int partition(int[] array, int l, int r) {
        //随机选择基准元素
        Random random = new Random();
        int p = l + random.nextInt(r - l);
        //交换基准元素到数组头
        swap(array, l, p);
        int x = array[l];
        //双指针
        int i = l + 1, j = r;
        while (i < j) {
            while (i < j && array[j] >= x) {
                j--;
            }
            while (i < j && array[i] < x) {
                i++;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }

        //交换基准元素到分界处
        swap(array, l, i);

        return i;

    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
