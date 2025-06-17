package leetcode.zhenhua.array;

import java.util.*;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
        }
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            while (deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            ans[i-k+1]=nums[deque.peekFirst()];
        }

        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int maxItem = nums[0];
        for (int i = 1; i < k; i++) {
            maxItem = Math.max(maxItem, nums[i]);
        }
        int j = 0;
        ans[j++] = maxItem;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= maxItem) {
                maxItem = nums[i];
            } else if (nums[i - k] == maxItem) {
                maxItem = nums[i];
                for (int m = i; m > i - k; m--) {
                    maxItem = Math.max(maxItem, nums[m]);
                }
            }
            ans[j++] = maxItem;
        }
        return ans;
    }
}
