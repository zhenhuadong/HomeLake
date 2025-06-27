package leetcode.zhenhua.linked.tree;

public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper){
        if(root == null){
            return true;
        }

        if(root.val <= lower || root.val >= upper){
            return false;
        }

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
    public static void main(String[] args) {
//        Integer[] nums = {5,1,4,null,null,3,6};
        Integer[] nums = {5,4,6,null,null,3,7};
//        Integer[] nums = {2,1,3};
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode98 l = new Leetcode98();
        System.out.println(l.isValidBST(root));
    }

}
