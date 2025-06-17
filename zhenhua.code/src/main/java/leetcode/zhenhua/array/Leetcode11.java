package leetcode.zhenhua.array;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.max;

public class Leetcode11 {

    public int maxArea(int @NotNull [] height) {
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


