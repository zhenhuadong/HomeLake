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

    public boolean verify(){
        Leetcode1 l = new Leetcode1();
        //Test case 1:
        int[] nums1 = new int[]{2,7,11,15};
        int target1 = 9;
        int[] result1 = new int[]{0,1};
        Arrays.equals(result1, twoSum1(nums1, target1));
        //Test case 2
        int[] nums2 = new int[]{3,2,4};
        int target2 = 6;
        int[] result2 = new int[]{1,2};

        //Test case 3
        int[] nums3 = new int[]{3,3};
        int target3 = 6;
        int[] result3 = new int[]{0,1};
        l.twoSum1()
    }
}
