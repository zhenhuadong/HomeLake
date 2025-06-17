package leetcode.zhenhua.array.test;

import leetcode.zhenhua.array.Leetcode1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Leetcode1Test {
    private Leetcode1 l;

    @Before
    public void setup(){
        System.out.println("Before");
        l =new Leetcode1();
    }

    @After
    public void teardown(){
        System.out.println("After");
    }

    @Test
    public void testSum1_case1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = new int[]{0, 1};
        Assert.assertArrayEquals(result, l.twoSum1(nums, target));
    }

    @Test
    public void testSum1_case2() {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = new int[]{1,2};
        Assert.assertArrayEquals(result, l.twoSum1(nums, target));
    }

    @Test
    public void testSum1_case3() {
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] result = new int[]{0,1};
        Assert.assertArrayEquals(result, l.twoSum1(nums, target));
    }

    @Test
    public void testSum2_case1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = new int[]{0, 1};
        Assert.assertArrayEquals(result, l.twoSum2(nums, target));
    }

    @Test
    public void testSum2_case2() {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = new int[]{1,2};
        Assert.assertArrayEquals(result, l.twoSum2(nums, target));
    }

    @Test
    public void testSum2_case3() {
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] result = new int[]{0,1};
        Assert.assertArrayEquals(result, l.twoSum2(nums, target));
    }
}
