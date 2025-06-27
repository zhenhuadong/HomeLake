package leetcode.zhenhua.linked.tree;

import java.util.*;

public class Leetcode114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,5,3,4,null,6};
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode114 l = new Leetcode114();
        l.flatten(root);
        System.out.println(TreeNode.orderTraversal(root,0));
    }
}
