package _数据结构与算法._动态规划;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _72编辑距离
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _72编辑距离 {
    int[][] memo;

    /**
     * 解法1：带备忘录的递归（动态规划）
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 从字符串1到字符串2的最小编辑距离
     */
    public int minDistance(String word1, String word2) {
        //1.状态定义：dp[i][j]表示s1[0-i]和s2[0-j]的最小编辑距离
        //2.初始化：
        //3.状态转移：

        //备忘录
        memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                memo[i][j] = -1;
            }
        }

        //i,j初始化指向最后一个索引
        return dp(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    /**
     * 递归版动态规划
     * @param i word1的指针，从右到左
     * @param j word2的指针，从右到左
     * @param word1 word1
     * @param word2 word2
     * @return 最小编辑距离
     */
    public int dp(int i, int j, String word1, String word2) {

        //i指针遍历完word1了，那么剩下操作数等于j+1（即word2的剩余的字符个数）
        if (i == -1) {
            return j + 1;
        }
        //j指针遍历完word2了，那么剩下操作数等于i+1（即word1的剩余的字符个数）
        if (j == -1) {
            return i + 1;
        }
        //看看是否是重复子问题，已经加入备忘录的
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        //做选择，4种情况
        //1.当前字符相等，则什么也不做（操作数不增加），i指针和j指针向左移动
        if (word1.charAt(i) == word2.charAt(j)) {
            //什么也不做
            memo[i][j] = dp(i - 1, j - 1, word1, word2);
        }
        //否则，在插入/删除/替换三种操作中选择一种最优的（即，操作数最少的），然后+1（这三种操作，都需要加一次操作）
        else {
            memo[i][j] = min(dp(i - 1, j - 1, word1, word2) + 1,//替换，i和j同时左移
                    dp(i, j - 1, word1, word2) + 1,//插入，插入的字符（i后面一位）和j所指的匹配，因此i不变，j左移
                    dp(i - 1, j, word1, word2) + 1);//删除，删除i所指的字符，i左移，j不变
        }
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    /**
     * 解法2：动态规划
     */
    public int minDistance2(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始化第0列，第0列表示word2为空字符
        for (int i = 0; i <= len1; i++) {
            //因此第0列的值取决于word1的长度
            dp[i][0] = i;
        }
        //初始化第0行，同理
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        //自底向上求解
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //若当前字符相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //和没有这个字符是一样的
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //否则，从插入/删除/替换三种操作中选一种最小值
                else {
                    dp[i][j] = min(dp[i][j - 1],//插入
                            dp[i - 1][j],//删除
                            dp[i - 1][j - 1]) + 1;//替换
                }
            }
        }
        //返回
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        _72编辑距离 instance = new _72编辑距离();
        System.out.println(instance.minDistance("rad", "apple"));
    }
}
