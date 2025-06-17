package leetcode.zhenhua.array;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length<1)
            return 0;
        Arrays.sort(nums);
        int longest = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1])
                continue;
            if(nums[i] == nums[i-1]+1){
                temp++;
                longest= longest<temp ? temp:longest;
            } else {
                temp=1;
            }
        }

        return longest;
    }
}
