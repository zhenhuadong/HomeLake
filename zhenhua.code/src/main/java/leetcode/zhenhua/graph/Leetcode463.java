package leetcode.zhenhua.graph;

import java.util.Objects;

public class Leetcode463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        boolean flag = true;
        for (int i = 0; i < grid.length && flag; i++) {
            for (int j = 0; j < grid[0].length && flag; j++) {
                if(grid[i][j] == 1){
                    flag = false;
                    ans = DFS(grid, i, j);
                }
            }
        }

        return ans;
    }

    public int DFS(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int perimeter = 4;
        int down = DFS(grid, i+1, j);
        int up = DFS(grid, i-1, j);
        int left = DFS(grid, i, j-1);
        int right = DFS(grid, i, j+1);
        if(up > 0){
            perimeter=perimeter + up -2;
        }
        if(down > 0){
            perimeter= perimeter + down - 2;
        }
        if(left > 0){
            perimeter= perimeter + left - 2;
        }
        if(right > 0){
            perimeter = perimeter + right - 2;
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid ={
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        int target = 16;
        Leetcode463 l = new Leetcode463();
        System.out.println(Objects.equals(target, l.islandPerimeter(grid)));
    }

}
