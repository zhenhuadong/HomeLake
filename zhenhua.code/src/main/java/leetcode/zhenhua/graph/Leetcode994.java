package leetcode.zhenhua.graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Leetcode994 {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int count = 0;
        if(grid == null || grid[0]==null){
            return ans;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){
                    queue.offer(i*grid[0].length + j);
                } else if(grid[i][j] == 1){
                    count+=1;
                }
            }
        }
        if(count == 0){
            return ans;
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                size--;
                int index = queue.poll();
                int r = index/grid[0].length;
                int c = index % grid[0].length;
                grid[r][c] =2;
                if(r+1 < grid.length && grid[r+1][c] == 1){
                    queue.offer((r+1)*grid[0].length + c);
                }
                if (r-1 >=0 && grid[r-1][c] == 1){
                    queue.offer((r-1)*grid[0].length + c);
                }
                if(c+1 < grid[0].length && grid[r][c+1] == 1){
                    queue.offer((r)*grid[0].length + c+1);
                }
                if (c-1 >=0 && grid[r][c-1] == 1){
                    queue.offer((r)*grid[0].length + c-1);
                }
            }
            if(queue.size()>0){
                ans++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] grid ={
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        int target = 4;
        Leetcode994 l = new Leetcode994();
        System.out.println(Objects.equals(target, l.orangesRotting(grid)));
    }

}
