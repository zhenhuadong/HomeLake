package leetcode.zhenhua.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args){
        Leetcode139 l = new Leetcode139();
        System.out.println(l.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
