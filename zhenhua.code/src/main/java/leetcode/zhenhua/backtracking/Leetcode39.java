package leetcode.zhenhua.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,target, ans, combine, 0);
        return ans;
    }

    public void  dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index){
        if(index == candidates.length){
            return;
        }

        if(target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }

        dfs(candidates,target, ans, combine,index+1);
        if(target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index], ans, combine, index);
            combine.remove(combine.size()-1);
        }
    }



    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Leetcode39 l = new Leetcode39();
        System.out.println(l.combinationSum(candidates,target));
    }
}
