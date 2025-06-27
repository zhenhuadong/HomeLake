package leetcode.zhenhua.linked.tree;

import java.util.Objects;

public class Leetcode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] left = maxDeepth(root.left);
        int[] right = maxDeepth(root.right);
        int deepth = Math.max(left[0], right[0]);
        int diameter = Math.max(left[1], right[1]);
        diameter = Math.max(left[0]+right[0], diameter);
        return diameter;
    }

    public int[] maxDeepth(TreeNode root) {
        if(root == null){
            return new int[]{0, 0};
        }
        int[] left = maxDeepth(root.left);
        int[] right = maxDeepth(root.right);
        int deepth = Math.max(left[0], right[0]);
        int diameter = Math.max(left[1], right[1]);
        diameter = Math.max(left[0]+right[0], diameter);
        return new int[]{deepth+1, diameter};
    }

    public static void main(String[] args) {
//        Integer[] nums = {1, 2, 3, 4, 5};
//        int target = 3;
        Integer[] nums = {1, 2};
        int target = 1;
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode543 l = new Leetcode543();
        System.out.println(Objects.equals(target, l.diameterOfBinaryTree(root)));
    }
}
