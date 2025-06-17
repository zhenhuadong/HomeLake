package leetcode.zhenhua.array;

public class Leetcode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n-1-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(temp,0, matrix, 0, n);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = {{7,4,1},{8,5,2},{9,6,3}};

        Leetcode48 l = new Leetcode48();
        l.rotate(matrix);
    }


}
