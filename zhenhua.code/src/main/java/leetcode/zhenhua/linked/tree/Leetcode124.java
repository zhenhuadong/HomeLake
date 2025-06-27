package leetcode.zhenhua.linked.tree;

import java.util.Objects;

public class Leetcode124 {
    public  int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        DFS(root);
        return ans;
    }

    public Integer DFS(TreeNode root){
        if(root == null){
            return 0;
        }
        Integer left = DFS(root.left);
        left = Math.max(left, 0);
        Integer right = DFS(root.right);
        right = Math.max(right, 0);
        ans = Math.max(ans, left + right + root.val);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        Integer[] nums = {-10,9,20,null,null,15,7};
        int target = 42;
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode124 l = new Leetcode124();
        System.out.println(Objects.equals(target, l.maxPathSum(root)));
    }

}
