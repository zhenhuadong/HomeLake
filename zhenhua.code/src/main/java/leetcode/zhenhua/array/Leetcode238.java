package leetcode.zhenhua.array;

public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] prefixProduct = new int[len];
        int[] suffixProduct = new int[len];
        for (int i = 0; i < len; i++) {
            if (0 == i) {
                prefixProduct[i] = 1;
                suffixProduct[len - i - 1] = 1;
            } else {
                prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
                suffixProduct[len - 1 - i] = suffixProduct[len - i] * nums[len - i];
            }
        }
        for (int i = 0; i < len; i++) {
            nums[i] = prefixProduct[i] * suffixProduct[i];
        }

        return nums;
    }
}