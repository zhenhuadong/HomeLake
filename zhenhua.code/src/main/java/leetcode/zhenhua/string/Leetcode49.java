package leetcode.zhenhua.string;

import java.util.*;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str : strs ){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> values = map.get(key);
            if(null == values) {
                values = new ArrayList<>();
                map.put(key, values);
                ans.add(values);
            }
            values.add(str);
        }

        return ans;
    }
}
