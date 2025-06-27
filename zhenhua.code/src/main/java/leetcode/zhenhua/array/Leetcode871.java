package leetcode.zhenhua.array;

import java.util.Objects;

public class Leetcode871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target)
            return 0;
        int[] dp = new  int[stations.length+1];
        dp[0] = startFuel;
        for(int i=0; i < stations.length; i++){
            for (int j = i; j >= 0; j--) {
                if(dp[j] >= stations[i][0]){
                    dp[j+1] = Math.max(dp[j+1], dp[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > target){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Leetcode871 l = new Leetcode871();
        int[][] stations = {};
        int target = 1;
        int startFuel = 1;
        System.out.println(Objects.equals(0, l.minRefuelStops(target,startFuel,stations)));
        int[][] stations1 = {{10,100}};
        int target1 = 100;
        int startFuel1 = 1;
        System.out.println(Objects.equals(-1, l.minRefuelStops(target1,startFuel1,stations1)));
        int target2 = 100;
        int startFuel2 = 10;
        int[][] stations2 = {{10,60},{20,30},{30,30},{60,40}};
        System.out.println(Objects.equals(2, l.minRefuelStops(target2,startFuel2,stations2)));
    }
}
