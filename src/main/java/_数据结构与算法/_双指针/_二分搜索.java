package _数据结构与算法._双指针;

/**
 * @ClassName: _二分搜索
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */
public class _二分搜索 {
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
