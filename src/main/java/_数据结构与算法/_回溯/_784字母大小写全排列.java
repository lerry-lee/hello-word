package _数据结构与算法._回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _784字母大小写全排列
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 */
public class _784字母大小写全排列 {
    /**
     * 解法1：回溯 (每一个字母都有两种选择：大写或者小写)
     * 技巧：使用异或运算转换字母大小写 ch ^ (1 << 5) (该运算会将大写字母转成小写字母，或将小写字母转成大写字母)
     */
    List<String> res;

    public List<String> letterCasePermutation(String S) {
        res = new ArrayList<>();
        backtrack(S.toCharArray(), 0);
        return res;
    }

    //基于原地转换法
    public void backtrack(char[] array, int t) {
        if (t == array.length) {
            res.add(new String(array));
            return;
        }

        char origin = array[t];
        //每次都有2种选择，字母转换/不转换
        //1.不转换，直接进入递归下一层
        backtrack(array, t + 1);
        //2.转换
//        if (Character.isUpperCase(origin)) {
//            //转成小写
//            array[t] = Character.toLowerCase(origin);
//            backtrack(array, t + 1);
//            array[t] = origin;
//        } else if (Character.isLowerCase(origin)) {
//            //转成大写
//            array[t] = Character.toUpperCase(origin);
//            backtrack(array, t + 1);
//            array[t] = origin;
//        }
        //基于位运算的转换
        if (Character.isAlphabetic(origin)) {
            array[t] ^= (1 << 5);
            backtrack(array, t + 1);
            array[t] = origin;
        }
    }

    public static void main(String[] args) {
        _784字母大小写全排列 instance = new _784字母大小写全排列();
        System.out.println(instance.letterCasePermutation("a1b2"));
    }
}
