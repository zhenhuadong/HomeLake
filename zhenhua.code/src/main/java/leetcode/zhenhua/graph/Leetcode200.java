package leetcode.zhenhua.graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Leetcode200 {

    public int numIslands(char[][] grid) {
        if(grid == null){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    ans++;
//                    DFS(grid,i,j);
                    grid[i][j] = '0';
                    BFS(grid, i, j);
                }
            }
        }

        return ans;
    }

    public void BFS(char[][] grid, int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer((i+1) * grid[0].length + j);
        queue.offer((i-1) * grid[0].length + j);
        queue.offer((i) * grid[0].length + j+1);
        queue.offer((i) * grid[0].length + j-1);

        while(!queue.isEmpty()){
            Integer index = queue.poll();
            int row = index / grid[0].length;
            int col = index % grid[0].length;
            if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
                continue;
            }
            if(grid[row][col] == '1'){
                grid[row][col] = '0';
                queue.offer((row+1) * grid[0].length + col);
                queue.offer((row-1) * grid[0].length + col);
                queue.offer((row) * grid[0].length + col+1);
                queue.offer((row) * grid[0].length + col-1);
            }
        }
    }
    public void DFS(char[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0){
            return;
        }
        if(grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        DFS(grid, i-1, j);
        DFS(grid, i+1, j);
        DFS(grid, i, j-1);
        DFS(grid, i, j+1);
    }

    public static void main(String[] args) {
        char[][] grid ={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int target = 3;
        Leetcode200 l = new Leetcode200();
        System.out.println(Objects.equals(target, l.numIslands(grid)));
    }

}
