package leetcode.zhenhua.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> items = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            items.add(map.get(digits.charAt(i)));
        }
        List<Character> chars = new ArrayList<>();
        combinations(items, chars, 0, ans);
        return ans;
    }

    public void combinations(List<String> items, List<Character> chars, int index, List<String> ans){
        if(index == items.size()){
            StringBuilder sb = new StringBuilder();
            chars.stream().forEach(sb::append);
//            for (char c:chars) {
//                sb.append(c);
//            }
            ans.add(sb.toString());
            return;
        }

        String item = items.get(index);
        for (int i = 0; i < item.length(); i++) {
            chars.add(item.charAt(i));
            combinations(items, chars, index+1, ans);
            chars.remove(chars.size()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        Leetcode17 l = new Leetcode17();
        System.out.println(l.letterCombinations(digits));
    }
}
