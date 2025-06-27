package leetcode.zhenhua.array;

import java.util.Arrays;
import java.util.Objects;

public class Leetcode1027 {
    public int longestArithSeqLength(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int x: nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        int delta = max - min;

        int ans = 1;
        for (int i = -delta; i <= delta; i++) {
            int[] dp = new int[max+1];
            Arrays.fill(dp, -1);
            for(int num: nums){
                int prev = num - i;
                if(prev >= min && prev <= max && dp[prev] != -1){
                    dp[num] = Math.max(dp[num], dp[prev] + 1);
                    ans = Math.max(ans, dp[num]);
                }
                dp[num] = Math.max(dp[num], 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {20,1,15,3,10,5,8};
        int target = 4;
        Leetcode1027 l = new Leetcode1027();
        System.out.println(Objects.equals(4, l.longestArithSeqLength(nums)));
    }
}
