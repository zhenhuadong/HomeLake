package leetcode.zhenhua.dynamicprogramming;

import java.util.Objects;

public class Leetcode70 {
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //测试上述方法
        System.out.println(Objects.equals(new Leetcode70().climbStairs(10), 89));
        System.out.println(Objects.equals(new Leetcode70().climbStairs(0),1));
    }
}
