package leetcode.zhenhua.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode131 {
    boolean[][] flag;
    List<String> temp;
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        int length = s.length();
        flag = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(flag[i], true);
        }
        for (int i = length-1; i >=0 ; i--) {
            for (int j = i+1; j < length ; j++) {
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i+1][j-1];
            }
        }
        DFS(s,0);
//        for (int i = 0; i < s.length(); i++) {
//            partitionwithlength(s,ans,i+1);
//        }
        return ans;
    }
    public void DFS(String s, int length){
        if(length == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = length; i < s.length(); i++) {
            if(flag[length][i]){
                temp.add(s.substring(length, i+1));
                DFS(s, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    /**
    public void partitionwithlength(String s,List<List<String>> ans,int length){
        if(length > s.length()){
            return;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - length +1; i++) {
            String temp = s.substring(i,i+length);
            int start = 0;
            int end = temp.length() -1;
            while(start <= end){
               if(temp.charAt(start) == temp.charAt(end)){
                   start++;
                   end--;
               } else {
                   break;
               }
            }
            if(start >= end){
                list.add(temp);
            }
        }
        if(list.size()>0){
            ans.add(list);
        }
    }
     */
    public static void main(String[] args) {
        Leetcode131 l = new Leetcode131();
        String s = "aab";
        System.out.println(l.partition(s));
    }
}
