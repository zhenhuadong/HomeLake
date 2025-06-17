package leetcode.zhenhua.string;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";

        int[] tCount = new int[128];
        int[] sCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)-'A']+=1;
            sCount[s.charAt(i)-'A']+=1;
        }

        int delta=0;
        for (int i = 0; i < 128; i++) {
            if(tCount[i] != 0 && tCount[i]>sCount[i]){
                delta++;
            }
        }
        if(delta==0)
            return s.substring(0,t.length());

        int ans_len = s.length();
        int ans_start = 0;
        int ans_end = 0;

        int left = 0;
        int right = 0;

        for (int i = t.length(); i < s.length(); i++) {
            int temp = s.charAt(i)-'A';
            if(tCount[temp] != 0){
                if(tCount[temp] - sCount[temp] == 1){
                    delta--;
                }
                sCount[temp]+=1;

                if(delta==0){
                    right=i;
                    for (int j = left; j <= right; j++) {
                        int index = s.charAt(j) - 'A';
                        if (tCount[index] != 0) {
                            if (sCount[index] == tCount[index]) {
                                if (right - left + 1<= ans_len) {
                                    ans_start = left;
                                    ans_end = right + 1;
                                    ans_len = right - left + 1;
                                }
                                left++;
                                sCount[index] -= 1;
                                delta++;
                                break;
                            }
                            sCount[index] -= 1;
                        }
                        left++;


                    }
                }
            }
        }


        return s.substring(ans_start, ans_end);
    }
}
