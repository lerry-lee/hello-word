package _数据结构与算法._回溯;

import java.util.*;

/**
 * @ClassName: _47全排列2
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class _47全排列2 {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
//        backtrack(nums, 0);
        Arrays.sort(nums);
        backtrack_sort(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    //交换法+hash判重
    public void backtrack(int[] nums, int t) {
        if (t == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }
        //用一个集合来判重
        Set<Integer> hashSet = new HashSet<>();
        for (int i = t; i < nums.length; i++) {
            //重复的不要
            if (!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
                swap(nums, t, i);
                backtrack(nums, t + 1);
                swap(nums, t, i);
            }
        }
    }

    //bool法+数组排序
    public void backtrack_sort(int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //重复的/访问过的，跳过
            //重点：这里有个细节!visited[i-1]，判重的时候，i-1必须已经访问过，不然就算i和i-1相同，也是可以选择的
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1]&&!visited[i-1])) {
                continue;
            }

            visited[i] = true;
            temp.add(nums[i]);
            backtrack_sort(nums, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);

        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
