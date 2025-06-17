package leetcode.zhenhua.array.test;

import junit.framework.Assert;
import leetcode.zhenhua.array.Leetcode11;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Leetcode11Test {
    Leetcode11 l = new Leetcode11();
    @Before
    public void setup(){
//        l = new Leetcode11();
        System.out.println("before");
    }

    @After
    public void teardown(){
        System.out.println("after");
    }

    @Test
    public void testMaxArea_case1(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int target = 49;
        Assert.assertEquals(target, l.maxArea(height));
    }

    @Test
    public void testMaxArea_case2(){
        int[] height = {1,1};
        int target = 1;
        Assert.assertEquals(target, l.maxArea(height));
    }
}
