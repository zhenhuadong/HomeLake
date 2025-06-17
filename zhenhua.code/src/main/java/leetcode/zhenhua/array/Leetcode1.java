package leetcode.zhenhua.array;

import java.util.Arrays;
import java.util.HashMap;


public class Leetcode1 {
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            int peer = target-nums[i];
            for(int j=i+1; j<nums.length; j++){
                if (peer == nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]), i};
            }
            hm.put(nums[i], i);
        }
        return null;
    }

}
