package leetcode.zhenhua.linked.tree;

import java.util.*;

public class Leetcode104 {

    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int lenth = queue.size();
            Deque<TreeNode> newQueue = new LinkedList<>();
            for (int i = 0; i < lenth; i++) {
                TreeNode temp = queue.pop();
                if(temp.left != null){
                    newQueue.offer(temp.left);
                }
                if(temp.right != null){
                    newQueue.offer(temp.right);
                }
            }
            queue.addAll(newQueue);
            ans++;
        }

        return ans;
    }

    public int maxDepth1(TreeNode root) {
        if(null == root){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        int target = 3;
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode104 l = new Leetcode104();

        System.out.println(Objects.equals(target, l.maxDepth(root)));
    }
}
