package _数据结构与算法._动态规划;

/**
 * @ClassName: _518零钱兑换2
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description TODO 完全背包问题？
 */
public class _518零钱兑换2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //状态定义：dp[i]表示凑成面额为i的硬币组合个数
        //状态转移：
        //初始化：dp[0]表示凑成面额为0元的硬币组合个数，此时只有一种，即0个硬币，所以dp[0]=1
        //除了0之外的其他的dp[i]都初始化为0
        dp[0] = 1;
        //面额以下的金额i不需要考虑，一定为0（除了i=0）

        //枚举硬币
        for (int coin : coins) {
            //枚举金额
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        _518零钱兑换2 instance = new _518零钱兑换2();
        System.out.println(instance.change(5, new int[]{1, 2, 5}));
        System.out.println(instance.change(3, new int[]{2}));
        System.out.println(instance.change(5, new int[]{5}));
    }
}
