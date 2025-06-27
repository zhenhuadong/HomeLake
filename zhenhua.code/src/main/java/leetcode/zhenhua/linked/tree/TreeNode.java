package leetcode.zhenhua.linked.tree;

import java.util.*;

public class TreeNode {
    public  int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {};
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] nums) {
        if(null == nums || nums.length < 1 || null == nums[0])
            return null;
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty() && i < nums.length){
            TreeNode current = queue.poll();

            if(i<nums.length && nums[i] != null){
                current.left = new TreeNode(nums[i]);
                queue.offer(current.left);
            }
            i++;
            if(i<nums.length && nums[i] != null){
                current.right = new TreeNode(nums[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> layerTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null )
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
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
        }
        return list;
    }
    public static List<Integer> orderTraversal(TreeNode root, int type){
        List<Integer> list = new ArrayList<>();
        if(null == root){
            return list;
        }
        if(type == 0){  // preorder
            list.add(root.val);
        }
        if(root.left != null){
            list.addAll(orderTraversal(root.left, type));
        }
        if(type == 1){ // inorder
            list.add(root.val);
        }
        if(root.right != null){
            list.addAll(orderTraversal(root.right, type));
        }
        if(type == 2){ // postorder
            list.add(root.val);
        }
        return list;
    }
}
