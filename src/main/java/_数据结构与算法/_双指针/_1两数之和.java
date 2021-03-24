package _数据结构与算法._双指针;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _1两数之和
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */
public class _1两数之和 {
    /**
     * 解法1：暴力枚举
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 解法2：哈希表
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

}
