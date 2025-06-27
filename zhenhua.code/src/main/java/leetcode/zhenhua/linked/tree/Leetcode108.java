package leetcode.zhenhua.linked.tree;

import java.util.Arrays;

public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        return arrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode arrayToBST(int[] nums, int start, int end){
        TreeNode node = null;
        if(start == end) {
            node = new TreeNode(nums[start]);
        } else if (start < end) {
            int index = (start+end) / 2;
            node = new TreeNode(nums[index]);
            node.left = arrayToBST(nums, start, index-1);
            node.right = arrayToBST(nums, index+1, end);
        }
        return node;
    }

    public static void main(String[] args) {

        int[] nums = {-10,-3,0,5,9};
        Leetcode108 l = new Leetcode108();
        System.out.println(TreeNode.layerTraversal(l.sortedArrayToBST(nums)));
    }

}
