package leetcode.zhenhua.linked.tree;

import java.util.*;

public class Leetcode230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root !=null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root=stack.pop();
            --k;
            if(k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    public static void main(String[] args) {
//        Integer[] nums = {5,3,6,2,4,null,null,1};
//        int k = 3;
        Integer[] nums = {3,1,4,null,2};
        int k = 1;
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode230 l = new Leetcode230();
        System.out.println(l.kthSmallest(root, k));
    }
}
