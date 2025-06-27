package leetcode.zhenhua.linked.tree;

import java.util.Stack;

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root.left);
        right.push(root.right);
        while(left.size() == right.size() && !left.isEmpty()){
            int size = left.size();
            while(size>0){
                TreeNode l = left.pop();
                TreeNode r = right.pop();
                if(l == null && r == null){
                    size--;
                    continue;
                }
                if(l == null || r == null){
                    return false;
                }
                if(l.val != r.val){
                    return false;
                }
                left.push(l.left);
                left.push(l.right);
                right.push(r.right);
                right.push(r.left);
                size--;
            }
        }

        if(!left.isEmpty() || !right.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,4,4,3};
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode101 l = new Leetcode101();
        System.out.println(l.isSymmetric(root));
    }

}
