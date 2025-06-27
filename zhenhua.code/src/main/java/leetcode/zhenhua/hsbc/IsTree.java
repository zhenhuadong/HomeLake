package leetcode.zhenhua.hsbc;

public class IsTree {

    public boolean valid = true;
    public boolean isTree(int[][] graph){
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = true;
            for (int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 1){
                    DFS(graph,j,visited);
                }
            }
        }
        return valid;
    }

    public void DFS(int[][] graph, int i, boolean[] visited){
        if(i<0 || i>=graph.length){
            return;
        }
        if(visited[i] == true){
            valid = false;
            return;
        }
        visited[i] = true;
        for (int j = 0; j < graph.length; j++) {
            if(graph[i][j] == 1){
                graph[i][j] = 0;
                graph[j][i] = 0;
                DFS(graph, j, visited);
            }
        }
    }


    public static void main(String[] args) {
        int[][] graph = {{0,1,0,1}, {1,0,1,0}, {0,1, 0, 0}, {1, 0, 0,0 }};
        IsTree isTree = new IsTree();
        System.out.println(isTree.isTree(graph));

    }
}
