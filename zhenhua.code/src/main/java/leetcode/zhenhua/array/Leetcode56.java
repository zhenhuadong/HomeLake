package leetcode.zhenhua.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>(){
             public int compare(int[] interval1, int[] interval2) {
                 return interval1[0] - interval2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l=intervals[i][0];
            int r=intervals[i][1];
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] < l){
                ans.add(new int[]{l, r});
            } else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], r);
            }
        }

        return ans.toArray(new int[ans.size()-1][]);
    }
}
