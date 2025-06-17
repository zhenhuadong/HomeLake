package leetcode.zhenhua.array;

public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean[] flag = new boolean[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int t = nums[i];
            if(t>0 && t <= len){
                flag[t-1]=true;
            }
        }
        for (int i = 0; i < len; i++) {
            ans=i+1;
            if(!flag[i]){
                return ans;
            }
        }
        return ans+1;
    }
}
