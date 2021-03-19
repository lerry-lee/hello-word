package _数据结构与算法._动态规划;

/**
 * @ClassName: _322零钱兑换
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _322零钱兑换 {
    /**
     * 解法1：动态规划
     * @param coins 不同面额的硬币
     * @param amount 总金额
     * @return 最少硬币个数，若无则返回-1
     */
    public int coinChange(int[] coins, int amount) {
        //1.状态定义：dp[i]表示当总金额为i时，凑成所需的最少硬币个数
        int[] dp = new int[amount + 1];
        //2.状态转移方程：当coin小于i时，凑成总金额为i的最少个数=凑成总金额为i-coin的最少个数+1（1表示coin这枚硬币）
        //dp[i]=min(dp[i],dp[i-coin]+1)

        //3.初始化：初始化所有dp[i]的值为一个不可达的值，这里只需初始化为amount+1即可，如果用int的最大值，可能出现越界

        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        //初始dp[0]=0，当总金额为0时，需要0枚硬币可以凑齐
        dp[0]=0;

        //遍历所有金额，从1到amount
        for (int i = 1; i <= amount; i++) {
            //遍历所有硬币取值，当coin<=i时，可转移
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //最终判断是否需要返回-1
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }
}
