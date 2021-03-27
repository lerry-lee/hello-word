package _数据结构与算法._二分搜索;

/**
 * @ClassName: _寻找两侧边界的二分搜索
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description
 */
public class _寻找两侧边界的二分搜索 {
    /**
     * 寻找target的左侧边界
     * @param nums 有序数组
     * @param target 目标值
     * @return 左侧索引下标，没有则返回-1
     */
    public int binarySearch_leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid;
            }
        }
        if(nums[left]==target){
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        _寻找两侧边界的二分搜索 instance=new _寻找两侧边界的二分搜索();
        System.out.println(instance.binarySearch_leftBound(new int[]{5,7,7,8,8,10},8));//3
        System.out.println(instance.binarySearch_leftBound(new int[]{5,7,7,8,8,10},7));//1
        System.out.println(instance.binarySearch_leftBound(new int[]{5,7,7,8,8,10},6));//-1
        System.out.println(instance.binarySearch_leftBound(new int[]{5,7,7,8,8,10},2));//-1
        System.out.println(instance.binarySearch_leftBound(new int[]{5,7,7,8,8,10},13));//-1
    }
}
