package leetcode.zhenhua.array;

import java.util.Arrays;
import java.util.Collections;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length-1; j++) {
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] >= amount ? -1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        Leetcode322 l = new Leetcode322();
        System.out.println(l.coinChange(coins,amount));
    }
}
