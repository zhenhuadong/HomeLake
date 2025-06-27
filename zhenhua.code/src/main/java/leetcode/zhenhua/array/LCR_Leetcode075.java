package leetcode.zhenhua.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class LCR_Leetcode075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Arrays.stream(arr1).max().getAsInt();
        int[] count = new int[max];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]+=1;
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < count[arr2[i]]; j++) {
                arr1[index++] = arr2[i];
            }
            count[arr2[i]] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr1[index++] = i;
            }
        }

        return arr1;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }

        Arrays.sort(arr1);

        for (int i = 0; i < arr1.length; i++) {
            int key = arr1[i];
            if(null != map.get(key)){
                map.put(key, map.get(key) + 1);
            }
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                ans[index++] = arr2[i];
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            if(null == map.get(arr1[i])){
                ans[index++] = arr1[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arry1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arry2 = {2,1,4,3,9,6};
        LCR_Leetcode075 l = new LCR_Leetcode075();
        System.out.println(Arrays.toString(l.relativeSortArray(arry1,arry2)));
    }
}
