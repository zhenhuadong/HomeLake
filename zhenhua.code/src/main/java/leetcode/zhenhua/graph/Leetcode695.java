package leetcode.zhenhua.graph;

import java.util.Objects;

public class Leetcode695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        if(grid == null || grid[0] == null){
            return ans;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    ans = Math.max(ans, DFS(grid,i,j));
                }
            }
        }

        return ans;
    }

    public int DFS(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int cnt = 1;
        cnt+=DFS(grid, i+1, j);
        cnt+=DFS(grid, i-1, j);
        cnt+=DFS(grid, i, j+1);
        cnt+=DFS(grid, i, j-1);
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid ={
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int target = 6;
        Leetcode695 l = new Leetcode695();
        System.out.println(Objects.equals(target, l.maxAreaOfIsland(grid)));
    }

}
