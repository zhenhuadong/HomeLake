package leetcode.zhenhua.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> output = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            output.add(nums[i]);
//        }

        List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());

        backtrack(output,0,ans);

        return ans;
    }

    public void backtrack(List<Integer> output, int i, List<List<Integer>> ans){
        if(i == output.size()){
            ans.add(new ArrayList<>(output));
        }
        for (int j = i; j < output.size(); j++) {
            Collections.swap(output, i, j);
            backtrack(output,i+1, ans);
            Collections.swap(output, j, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Leetcode46 l = new Leetcode46();
        System.out.println(l.permute(nums));
    }

}
