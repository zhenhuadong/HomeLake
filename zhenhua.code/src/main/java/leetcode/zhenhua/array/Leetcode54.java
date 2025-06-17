package leetcode.zhenhua.array;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> target = new ArrayList<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int up = 0;
        int down = rowLen;
        int left = 0;
        int right = colLen;

        while (up < down && left < right){
            for (int i = left; i < right ; i++) {
                target.add(matrix[up][i]);
            }
            for (int i = up+1; i < down; i++) {
                target.add(matrix[i][right-1]);
            }
            if(up+1 < down) {
                for (int i = right - 2; i >= left; i--) {
                    target.add(matrix[down - 1][i]);
                }
            }
            if(left+1 < right) {
                for (int i = down - 2; i > up; i--) {
                    target.add(matrix[i][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }

        return target;
    }
}
