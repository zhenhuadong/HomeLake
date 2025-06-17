package leetcode.zhenhua.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (null == s || null == p)
            return ans;
        int plen = p.length();
        int slen = s.length();
        if(plen > slen){
            return ans;
        }
        int[] count = new int[26];
        for (int i = 0; i < plen; i++) {
            count[p.charAt(i) - 'a']+=1;
            count[s.charAt(i) - 'a']-=1;
        }
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if(count[i] != 0){
                differ++;
            }
        }
        if(0 == differ){
            ans.add(0);
        }

        for (int i = 0; i < slen-plen; i++) {
            int indexLeft = s.charAt(i) - 'a';
            if(count[indexLeft] == -1){
                differ--;
            }else if(count[indexLeft] == 0){
                differ++;
            }
            count[indexLeft] +=1;

            int indexRight = s.charAt(i+plen) - 'a';
            if(count[indexRight] == 1){
                differ--;
            }else if(count[indexRight] == 0){
                differ++;
            }
            count[indexRight] -=1;

            if(differ==0){
                ans.add(i+1);
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (null == s || null == p || p.length() < 1 || p.length() > s.length())
            return ans;
        char[] c = p.toCharArray();
        Arrays.sort(c);
        String expect = new String(c);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String t = s.substring(i, i + p.length());
            char[] temp = t.toCharArray();
            Arrays.sort(temp);
            if (expect.equals(new String(temp)))
                ans.add(i);
        }
        return ans;
    }
}
