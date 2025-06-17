package leetcode.zhenhua.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1)
            return 0;
        int ans = 1;
        int left=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.keySet().contains(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, i);
            if(ans <= i - left){
                ans = i - left + 1;
            }
        }

        return ans;
    }
}
