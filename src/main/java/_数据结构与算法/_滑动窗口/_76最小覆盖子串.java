package _数据结构与算法._滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _76最小覆盖子串
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description
 */
public class _76最小覆盖子串 {
    /**
     * 解法1：滑动窗口+哈希表 时间O(NS+T) 空间O(S)  N是字符串s的长度，S是字符集的大小，T是字符串t的长度
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        //[left,right)
        int left = 0, right = 0;
        //记录最小长度
        int minLen = Integer.MAX_VALUE;
        //记录最小子串的起止下标，用于截取子串
        int start = 0, end = s.length() - 1;
        while (right < s.length()) {
            char cR = s.charAt(right);
            right++;
            //若当前字符不在字符串t中，则不需要处理
            if (!freq.containsKey(cR)) {
                continue;
            }
            window.put(cR, window.getOrDefault(cR, 0) + 1);
            //判断左窗口是否需要收缩
            while (check(freq, window) && left <= right) {
                //判断最小长度
                if (right - left < minLen) {
                    end = right;
                    start = left;
                    minLen = right - left;
                }
                char cL = s.charAt(left);
                left++;
                //若当前字符不在字符串t中，则不需要处理
                if (!freq.containsKey(cL)) {
                    continue;
                }
                int count = window.get(cL);
                if (count == 1) {
                    window.remove(cL);
                } else {
                    window.put(cL, count - 1);
                }
            }
        }
        //若minLen为初始值，则说明没有匹配的子串，返回空串
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, end);
    }

    public boolean check(Map<Character, Integer> freq, Map<Character, Integer> window) {
        for (Character c : freq.keySet()) {
            if (window.containsKey(c)) {
                if (window.get(c) < freq.get(c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法2：解法1时间优化 使用distance变量记录freq和window相同/符合要求的字符个数
     */
    public String minWindow2(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        //[left,right)
        int left = 0, right = 0;
        //记录最小长度
        int minLen = Integer.MAX_VALUE;
        //记录最小子串的起止下标，用于截取子串
        int start = 0, end = s.length() - 1;
        //记录符合要求的字符个数
        int distance = 0;
        while (right < s.length()) {
            char cR = s.charAt(right);
            right++;
            //若当前字符不在字符串t中，则不需要处理
            if (!freq.containsKey(cR)) {
                continue;
            }
            window.put(cR, window.getOrDefault(cR, 0) + 1);
            //重点：只有当前字符的个数小于freq中的个数时，distance才+1，否则多出来的无益
            //这里用>=是因为，上面一行代码先进行了加1操作
            if (freq.get(cR) >= window.get(cR)) {
                distance++;
            }
            //判断左窗口是否需要收缩
            while (distance == t.length() && left <= right) {
                //判断最小长度
                if (right - left < minLen) {
                    end = right;
                    start = left;
                    minLen = right - left;
                }
                char cL = s.charAt(left);
                left++;
                //若当前字符不在字符串t中，则不需要处理
                if (!freq.containsKey(cL)) {
                    continue;
                }
                //重点：只有当前字符的个数==freq中的个数时，distance才-1，否则多出来的无益
                if (freq.get(cL).equals(window.get(cL))) {
                    distance--;
                }
                int count = window.get(cL);
                if (count == 1) {
                    window.remove(cL);
                } else {
                    window.put(cL, count - 1);
                }
            }
        }
        //若minLen为初始值，则说明没有匹配的子串，返回空串
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        _76最小覆盖子串 instance = new _76最小覆盖子串();
        System.out.println(instance.minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(instance.minWindow2("a", "a"));
    }
}
