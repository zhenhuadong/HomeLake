package leetcode.zhenhua.array;

import java.util.HashMap;

public class Leetcode560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
