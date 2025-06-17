package leetcode.zhenhua.array;

public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        if(matrix[0][0] > target || matrix[rowLen-1][colLen-1] < target)
            return false;

        int x = 0;
        int y = colLen-1;
        while(x<rowLen && y >= 0){
            if(matrix[x][y] == target){
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }

        return  false;
    }

    public static void main(String[] args) {
        Leetcode240 l = new Leetcode240();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;

        System.out.println(l.searchMatrix(matrix, target)==true);
        ;
    }
}
