package _数据结构与算法._二分搜索;

/**
 * @ClassName: _剑指Offer53_1_在排序数组中查找数字
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description 统计一个数字在排序数组中出现的次数。
 */
public class _剑指Offer53_1_在排序数组中查找数字 {
    /**
     * 解法1：二分搜索+中心扩展 时间O(logN) 最坏O(n) 空间O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                for (int i = mid; i >= 0 && nums[i] == target; i--) {
                    count++;
                }
                for (int i = mid + 1; i < nums.length && nums[i] == target; i++) {
                    count++;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return count;
    }

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
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    public int binarySearch_rightBound(int[] nums, int target) {
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
            }
            //nums[mid]==target,left也要更新为mid+1，因为当left+1=right时，mid=left，将陷入死循环
            else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (left > 0 && nums[left - 1] == target) {
            return left - 1;
        }
        return -1;
    }


    /**
     * 解法2：找target左右边界 时间O(logN) 空间O(1)
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int leftBound = binarySearch_leftBound(nums, target);
        if (leftBound == -1) {
            return 0;
        }
        int rightBound = binarySearch_rightBound(nums, target);
        return rightBound - leftBound + 1;
    }

    public static void main(String[] args) {
        _剑指Offer53_1_在排序数组中查找数字 instance = new _剑指Offer53_1_在排序数组中查找数字();
        System.out.println(instance.search2(new int[]{5, 7, 7, 8, 8, 10}, 8));//2
        System.out.println(instance.search2(new int[]{5, 7, 7, 8, 8, 10}, 6));//0
        System.out.println(instance.search2(new int[]{2, 2}, 2));//2
        System.out.println(instance.binarySearch_rightBound(new int[]{2, 2}, 2));//1
        System.out.println(instance.binarySearch_rightBound(new int[]{2, 2}, 3));//-1
        System.out.println(instance.binarySearch_rightBound(new int[]{2, 2}, 1));//-1
    }
}
