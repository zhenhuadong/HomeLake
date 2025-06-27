package leetcode.zhenhua.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Leetcode207 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if(visited[i] == 0){
                DFS(i);
            }
        }

        return valid;
    }

    public void DFS(int i){
        visited[i] = 1;
        for(int v:edges.get(i)){
            if(visited[v] == 0){
                DFS(v);
                if(!valid)
                    return;
            } else if (visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }

    public static void main(String[] args) {
        int[][] prerequisites ={
                {1,4},
                {2,4},
                {3,2},
                {3,1},
        };
        int numCourses = 5;

        Leetcode207 l = new Leetcode207();
        System.out.println(Objects.equals(true, l.canFinish(numCourses, prerequisites)));
    }

}
