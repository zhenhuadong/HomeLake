package leetcode.zhenhua.array;

import java.util.Arrays;

public class Leetcode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes,(a, b) -> a[1] - b[1]);
        int ans = 0;
        for (int i = boxTypes.length-1; i >=0 ; i--) {
            if(truckSize > boxTypes[i][0]){
                truckSize -= boxTypes[i][0];
                ans = ans + boxTypes[i][1] * boxTypes[i][0];
            } else {
                ans = ans + boxTypes[i][1] * truckSize;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        Leetcode1710 l = new Leetcode1710();
        System.out.println(l.maximumUnits(boxTypes,truckSize));
    }
}
