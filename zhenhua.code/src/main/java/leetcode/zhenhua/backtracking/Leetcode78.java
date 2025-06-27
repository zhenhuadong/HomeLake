package leetcode.zhenhua.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> record = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < 1<<n; mask++) {
            record.clear();
            for (int i = 0; i < n; i++) {
                if((mask & 1<<i) != 0){
                    record.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(record));
        }

        return ans;
    }

//    public void backtrack(int[] nums, List<Integer> record, int index, List<List<Integer>> ans){
//        if(index == 0){
//            ans.add(new ArrayList<>(record));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            record.add(nums[i]);
//            backtrack(nums,record, index-1, ans);
//        }
//    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Leetcode78 l = new Leetcode78();
        System.out.println(l.subsets(nums));
    }
}
