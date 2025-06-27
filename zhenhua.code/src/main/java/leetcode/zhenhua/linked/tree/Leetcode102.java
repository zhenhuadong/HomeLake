package leetcode.zhenhua.linked.tree;

import java.util.*;

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if(root == null)
            return arr;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            if(list.size()>0){
                arr.add(list);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode102 l = new Leetcode102();
        System.out.println(l.levelOrder(root));
    }
}
