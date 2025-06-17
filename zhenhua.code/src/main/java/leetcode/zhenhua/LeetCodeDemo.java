import leetcode.zhenhua.array.*;
import leetcode.zhenhua.utils.LeetcodeUtil;

import java.util.Arrays;

public class LeetCodeDemo {
    public static void main(String[] args) {
        System.out.println("Hello Leetcode");
        String s="hello world";
        Leetcode1 lc = new Leetcode1();
        System.out.println(LeetcodeUtil.arraysEquals(LeetcodeUtil.toIntegerArray(lc.result1),
                LeetcodeUtil.toIntegerArray(lc.twoSum1(lc.nums1, lc.target1))));
        System.out.println(Arrays.equals(lc.result1, lc.twoSum1(lc.nums1, lc.target1)));
        System.out.println(Arrays.equals(lc.result2, lc.twoSum1(lc.nums2, lc.target2)));
        System.out.println(Arrays.equals(lc.result3, lc.twoSum1(lc.nums3, lc.target3)));
        System.out.println(Arrays.equals(lc.result1, lc.twoSum2(lc.nums1, lc.target1)));
        System.out.println(Arrays.equals(lc.result2, lc.twoSum2(lc.nums2, lc.target2)));
        System.out.println(Arrays.equals(lc.result3, lc.twoSum2(lc.nums3, lc.target3)));
    }
}
