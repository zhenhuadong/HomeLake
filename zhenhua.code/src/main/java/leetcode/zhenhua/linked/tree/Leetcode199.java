package leetcode.zhenhua.linked.tree;

import java.util.*;

public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>1){
                TreeNode current = queue.poll();
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
                size--;
            }
            TreeNode last = queue.poll();
            if(last.left != null){
                queue.offer(last.left);
            }
            if(last.right != null){
                queue.offer(last.right);
            }
            list.add(last.val);
        }

        return list;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,null,null,null,5};
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode199 l = new Leetcode199();
        System.out.println(l.rightSideView(root));
    }
}
