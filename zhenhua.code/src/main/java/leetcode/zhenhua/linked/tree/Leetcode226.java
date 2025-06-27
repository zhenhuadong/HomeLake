package leetcode.zhenhua.linked.tree;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if(null == root){
            return root;
        }

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        List<Integer> target = Arrays.asList(4,7,2,9,6,3,1);
        TreeNode root = TreeNode.buildTree(nums);
        Leetcode226 l = new Leetcode226();
        System.out.println(Objects.equals(target, TreeNode.layerTraversal(l.invertTree(root))));
    }
}
