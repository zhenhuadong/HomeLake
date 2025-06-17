package leetcode.zhenhua.utils;

import java.util.Arrays;

public class LeetcodeUtil {

    public static Integer[] toIntegerArray(int[] source){
        return Arrays.stream(source).boxed().toArray(Integer[]::new);
    }

    public static <T> boolean arraysEquals(T[] expect, T[] real){
        if(expect == real)
            return true;
        if (null == expect || null == real)
            return false;
        if (expect.length != real.length)
            return false;

        for(int i=0; i<expect.length; i++) {
            if (expect[i] != real[i])
                return false;
        }
        return true;
    }
}


