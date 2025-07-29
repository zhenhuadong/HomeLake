package leetcode.zhenhua.backtracking;

import java.util.Objects;

public class Leetcode79 {
    public boolean found = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder cur = new StringBuilder();
                boolean[] visisted = new boolean[board.length*board[0].length];
                backtrack(board,word, cur, visisted, i, j);
                if(found){
                    return true;
                }
            }
        }
        return found;
    }

    public void backtrack(char[][] board, String word, StringBuilder cur, boolean[] visited, int row, int col){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || cur.length() >= word.length() || found){
            return;
        }
        int index = row * board[0].length + col;
        if(visited[index] == true){
            return;
        }
        visited[index] = true;
        cur.append(board[row][col]);
        if(word.equals(cur.toString())){
            found = true;
            return;
        }
        if(word.startsWith(cur.toString())){
            backtrack(board, word, cur, visited, row+1, col);
            backtrack(board, word, cur, visited, row-1, col);
            backtrack(board, word, cur, visited, row, col+1);
            backtrack(board, word, cur, visited, row, col-1);
        }
        cur.deleteCharAt(cur.length() - 1);
        visited[index] = false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        char[][] board = {{'a', 'b'}, {'c', 'd'}};
//        String word = "cdba";
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        Leetcode79 l = new Leetcode79();
        System.out.println(Objects.equals(true, l.exist(board,word)));
    }
}
