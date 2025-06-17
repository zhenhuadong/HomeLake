package leetcode.zhenhua.array;

import java.util.Arrays;

public class Leetcode189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            newArr[(i+k) % len] = nums[i];
        }
        System.arraycopy(newArr,0, nums, 0, len);
    }
}
