package leetcode.zhenhua.hsbc;

import java.util.*;

public class BiggestHouse {
    public List<Integer> findHouse(int[][] house){
        Arrays.sort(house, (a,b) -> a[1] - b[1]);
        int biggest = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < house.length; i++) {
            if(biggest < house[i][1] - house[i-1][1]){
                biggest = house[i][1] - house[i-1][1];
                ans.clear();
                ans.add(house[i-1][0]);
                ans.add(house[i][0]);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] house = {{3,7}, {1,9}, {2, 0}, {5,15}, {4,30}};
        BiggestHouse bh = new BiggestHouse();
        System.out.println(bh.findHouse(house));

    }
}
