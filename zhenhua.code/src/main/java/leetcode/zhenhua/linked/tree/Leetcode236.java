package leetcode.zhenhua.linked.tree;

import java.util.Objects;

public class Leetcode236 {
    public  TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root, p, q);
        return ans;
    }

    public boolean DFS(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        boolean left = DFS(root.left, p, q);
        boolean right = DFS(root.right, p, q);
        if((left && right) || ((root.val == p.val||root.val == q.val) && (left || right))){
            ans = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }

    public static void main(String[] args) {
        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
        Integer[] nums1 = {5};
        Integer[] nums2 = {1};

        int target = 3;
        TreeNode root = TreeNode.buildTree(nums);
        TreeNode p = TreeNode.buildTree(nums1);
        TreeNode q = TreeNode.buildTree(nums2);

        Leetcode236 l = new Leetcode236();
        System.out.println(Objects.equals(target,
                l.lowestCommonAncestor(root, p, q)));
    }
}
