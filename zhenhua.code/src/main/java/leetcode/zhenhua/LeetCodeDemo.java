package leetcode.zhenhua;

import leetcode.zhenhua.array.*;
import leetcode.zhenhua.string.*;
import leetcode.zhenhua.utils.*;

import java.util.Arrays;

public class LeetCodeDemo {
    public static void main(String[] args) {
        System.out.println("Hello Leetcode");
        String hw = "hello world";

        Leetcode54 l = new Leetcode54();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] target = {1,2,3,6,9,8,7,4,5};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[] target = {1,2,3,4,8,12,11,10,9,5,6,7};
//        int[][] matrix = {{3},{2}};
//        int[] target = {3, 2};
        System.out.println(l.spiralOrder(matrix).toString().equals(Arrays.toString(target)));

//        Leetcode41 l = new Leetcode41();
//        int[] nums = {1,2,0};
//        System.out.println(l.firstMissingPositive(nums)==3);

//        Leetcode238 l = new Leetcode238();
//        int[] nums = {1,2,3,4};
//        int[] target = {24,12,8,6};
//        System.out.println(Arrays.equals(target, l.productExceptSelf(nums)));

//        Leetcode189 l = new Leetcode189();
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;
//        l.rotate(nums,k);
//        System.out.println(Arrays.toString(nums));

//        Leetcode56 l = new Leetcode56();
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        System.out.println(l.merge(intervals).length);

//        Leetcode53 l = new Leetcode53();
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(l.maxSubArray(nums));

//        Leetcode76 l = new Leetcode76();
//        String s = "abc";
//        String t = "ac";
//        System.out.println(l.minWindow(s,t));

//        Leetcode239 l = new Leetcode239();
//        int[] nums = {1,3,1,2,0,5};
//        int k = 3;
//        System.out.println(Arrays.stream(l.maxSlidingWindow(nums,k)).boxed().toList());
//        Leetcode560 l = new Leetcode560();
//        int[] nums = new int[]{1,-1,0};
//        int k=0;
//        System.out.println(l.subarraySum(nums, k));

//        Leetcode438 l = new Leetcode438();
//        String s = "cbaebabacd";
//        String p = "abc";
//        System.out.println(l.findAnagrams(s,p));

//        Leetcode3 l = new Leetcode3();
//        String s = "abba";
//        System.out.println(l.lengthOfLongestSubstring(s));

//        Leetcode42 l = new Leetcode42();
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(l.trap(height));
//        Leetcode283 l = new Leetcode283();
//        int[] nums = new int[]{0,1,0,3,12};
//        l.moveZeroes(nums);

//        Leetcode128 l = new Leetcode128();
//        int[] nums = new int[] {100,4,200,1,3,2};
//        int[] nums = new int[] {9,1,4,7,3,-1,0,5,8,-1,6};
//        System.out.println(l.longestConsecutive(nums));

//        Leetcode49 l = new Leetcode49();
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        System.out.println(l.groupAnagrams(strs));


//        Leetcode26 l = new Leetcode26();
//        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(l.removeDuplicates(nums1));

//        Leetcode15 l = new Leetcode15();
//        int[] nums1 = new int[]{-1,0,1,2,-1,-4};
//        int[] nums2 = new int[]{0,1,1};
//        int[] nums3 = new int[]{0,0,0};
//        System.out.println(l.threeSum(nums1));
//        System.out.println(l.threeSum(nums2));
//        System.out.println(l.threeSum(nums3));
//        int[] nums4 = new int[] {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};//
//        System.out.println(l.threeSum(nums4).size());


//        Leetcode1 lc = new Leetcode1();
//        System.out.println(LeetcodeUtil.arraysEquals(LeetcodeUtil.toIntegerArray(lc.result1),
//                LeetcodeUtil.toIntegerArray(lc.twoSum1(lc.nums1, lc.target1))));
//        System.out.println(Arrays.equals(lc.result1, lc.twoSum1(lc.nums1, lc.target1)));
//        System.out.println(Arrays.equals(lc.result2, lc.twoSum1(lc.nums2, lc.target2)));
//        System.out.println(Arrays.equals(lc.result3, lc.twoSum1(lc.nums3, lc.target3)));
//        System.out.println(Arrays.equals(lc.result1, lc.twoSum2(lc.nums1, lc.target1)));
//        System.out.println(Arrays.equals(lc.result2, lc.twoSum2(lc.nums2, lc.target2)));
//        System.out.println(Arrays.equals(lc.result3, lc.twoSum2(lc.nums3, lc.target3)));
    }
}
