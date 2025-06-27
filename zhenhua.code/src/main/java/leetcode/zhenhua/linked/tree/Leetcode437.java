package leetcode.zhenhua.linked.tree;

public class Leetcode437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        int ret = 0;

        ret += DFS(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int DFS(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        int ret = 0;
        if(root.val == targetSum){
            ret = 1;
        }
        ret += DFS(root.left, targetSum-root.val);
        ret += DFS(root.right, targetSum-root.val);
        return ret;
    }

    public static void main(String[] args) {
//        Integer[] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
//        int targetSum = 3;
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum = 22;
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode437 l = new Leetcode437();
        System.out.println(l.pathSum(root, targetSum));
    }
}
