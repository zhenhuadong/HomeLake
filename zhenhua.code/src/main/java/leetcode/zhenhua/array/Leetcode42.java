package leetcode.zhenhua.array;

public class Leetcode42 {
    public int trap(int[] height) {
        if(null == height || height.length< 3)
            return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        int k = height.length-1;
        right[k]=height[k];
        for (int i = 1; i < height.length-1; i++) {
            left[i] = Math.max(height[i], left[i-1]);
            k--;
            right[k]=Math.max(height[k], right[k+1]);
        }
        left[height.length-1] = Math.max(height[height.length-1], left[height.length-2]);
        right[0] = Math.max(height[0], right[1]);

        int sum=0;
        for (int i = 0; i < height.length; i++) {
            sum+=Math.min(left[i], right[i]) - height[i];
        }

        return sum;
    }
}
