package leetcode.zhenhua.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
//        int[] res = Arrays.stream(nums).distinct().toArray();
//        IntStream.range(0, res.length).forEach(i -> nums[i]=res[i]);
//        return res.length;

        if(nums.length<1)
            return 0;
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(k>0 && nums[k] == nums[i]) continue;
            nums[k++]=nums[i];
        }
        return k;
    }
}
