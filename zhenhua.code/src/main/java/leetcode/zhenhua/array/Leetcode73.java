package leetcode.zhenhua.array;

public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[] x = new boolean[rowLen];
        boolean[] y = new boolean[rowLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(matrix[i][j] == 0){
                    x[i]=true;
                    y[j]=true;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            if(x[i]){
                for (int j = 0; j < colLen; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        for (int j = 0; j < colLen; j++) {
            if(y[j]){
                for (int i = 0; i < rowLen; i++) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}
