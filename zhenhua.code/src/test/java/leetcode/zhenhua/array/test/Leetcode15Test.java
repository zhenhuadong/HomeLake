package leetcode.zhenhua.array.test;

import leetcode.zhenhua.array.Leetcode15;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Leetcode15Test {
    Leetcode15 l = new Leetcode15();

    @Before
    public void setup(){
        System.out.println("before");
    }

    @After
    public void teardown(){
        System.out.println("after");
    }

    @Test
    public void testTreenumber_case1(){
        int[] nums = {-1,0,1,2,-1,-4};
        int[][] target = {{-1,-1,2}, {-1,0,1}};
        l.threeSum(nums);
    }

}
