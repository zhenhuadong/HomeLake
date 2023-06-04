import java.util.*;

import static java.lang.Math.max;

public class LeetCode11 {
    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
//        System.out.println(maxArea(height));
//        int[] nums = Arrays.asList(-1,0,1,2,-1,-4);
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Boolean> hashMap = new HashMap<String, Boolean>();
        List<Integer> item = new ArrayList<>();

        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(0==(nums[i]+nums[j]+nums[k])){
                        int[] temp = {nums[i],nums[j],nums[k]};
                        Arrays.sort(temp);

                    }
                }
            }
        }

        return null;
    }
    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int area=0;
        while(i<j){
            if (height[i] < height[j]){
                area=max(area, (j-i) * height[i]);
                i++;
            } else{
                area=max(area, (j-i) * height[j]);
                j--;
            }
        }
        return area;
    }
}
