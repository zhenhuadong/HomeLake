package leetcode.zhenhua.linked.tree;

import java.util.*;

public class Leetcode94 {

    public class  TreeNodeFlag{
        public TreeNode node;
        public boolean flag;
        public TreeNodeFlag(TreeNode node, boolean flag){
            this.flag = flag;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(null == root){
            return ans;
        }
        Stack<TreeNodeFlag> stack = new Stack<>();
        stack.push(new TreeNodeFlag(root,false));

        while (!stack.isEmpty()){
            TreeNodeFlag currentFlag = stack.pop();
            TreeNode current = currentFlag.node;
            if(null == current){
                continue;
            }
            if(! currentFlag.flag){
//                stack.push(new TreeNodeFlag(current, true));  // postorderTraversal
                stack.push(new TreeNodeFlag(current.right, false));
                stack.push(new TreeNodeFlag(current,true)); // inorderTraversal
                stack.push(new TreeNodeFlag(current.left, false));
//                stack.push(new TreeNodeFlag(current, true));  // preorderTraversal

            } else {
                ans.add(current.val);
            }
        }

        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(null == root){
            return ans;
        }

//        ans.add(root.val);  // preoderTraversal

        if(root.left != null){
            ans.addAll(inorderTraversal(root.left));
        }

        ans.add(root.val);  // inoderTraversal

        if(root.right != null){
            ans.addAll(inorderTraversal(root.right));
        }
//        ans.add(root.val);  // postoderTraversal

        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,null,2,3};
        List<Integer> target = Arrays.asList(1, 3, 2);
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode94 l = new Leetcode94();

        System.out.println(Objects.equals(target, l.inorderTraversal(root)));
    }


    private static boolean equals(TreeNode source, TreeNode target) {
        if(source == target)
            return true;
        if(null == source || null == target)
            return false;

        if(source.val == target.val && equals(source.left, target.left) && equals(source.right, target.right)){
             return true;
        }

        return false;
    }
}
