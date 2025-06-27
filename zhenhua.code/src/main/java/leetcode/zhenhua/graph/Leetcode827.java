package leetcode.zhenhua.graph;

import java.util.Arrays;
import java.util.Objects;

public class Leetcode827 {
    public int largestIsland(int[][] grid) {
        int ans = 0;
        int k = 2;
        if(grid == null || grid[0] == null){
            return ans;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    ans = Math.max(ans, DFS(grid, i, j, k));
                    k++;
                    grid[i][j] = 0;
                }
            }
        }
        return ans == 0 ? grid.length*grid[0].length : ans;
    }
    public int DFS(int[][] grid, int i, int j, int k){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }
        if(grid[i][j] == k){
            return 0;
        }
        grid[i][j] = k;
        int cnt = 1;
        cnt+=DFS(grid,i+1,j, k);
        cnt+=DFS(grid,i-1,j, k);
        cnt+=DFS(grid, i, j+1, k);
        cnt+=DFS(grid, i, j-1, k);
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid ={
                {0,0,0,0,0,0,0},
                {0,1,1,1,1,0,0},
                {0,1,0,0,1,0,0},
                {1,0,1,0,1,0,0},
                {0,1,0,0,1,0,0},
                {0,1,0,0,1,0,0},
                {0,1,1,1,1,0,0}
        };
        int target = 18;
        Leetcode827 l = new Leetcode827();
        System.out.println(Objects.equals(target, l.largestIsland(grid)));
    }

}
