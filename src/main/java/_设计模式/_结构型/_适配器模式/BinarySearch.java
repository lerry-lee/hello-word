package _设计模式._结构型._适配器模式;

/**
 * @ClassName: BinarySearch
 * @Author: lerry_li
 * @CreateDate: 2021/02/28
 * @Description 适配者：二分查找类
 */
public class BinarySearch {
    public int search(int[] array, int key) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == key) {
                //找到元素返回元素下标
                return mid;
            }
            if (array[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        //未找到元素返回1
        return -1;
    }
}
