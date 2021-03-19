package _数据结构与算法._回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _46全排列
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _46全排列 {
    /**
     * 解法1：回溯（swap）
     * 解法2：回溯（bool）
     */
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
//        backtrack(nums, 0);
        backtrack_bool(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    //法1：交换法
    public void backtrack(int[] nums, int t) {
        if (t == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }
        for (int i = t; i < nums.length; i++) {
            swap(nums, t, i);
            backtrack(nums, t + 1);
            swap(nums, t, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //法2：bool法
    public void backtrack_bool(int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                backtrack_bool(nums, temp, visited);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}
