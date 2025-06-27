package leetcode.zhenhua.linked.tree;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {
    public Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeRecursive(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTreeRecursive(int[] preorder,
                                       int[] inorder,
                                       int p_start,
                                       int p_end,
                                       int i_start,
                                       int i_end
                                       ){
        if(p_start > p_end || i_start > i_end)
            return null;
        int index = map.get(preorder[p_start]);
        int left_length = index - i_start;
        TreeNode root = new TreeNode(preorder[p_start]);
        root.left = buildTreeRecursive(preorder, inorder, p_start + 1, p_start + left_length, i_start, index-1);
        root.right = buildTreeRecursive(preorder, inorder, p_start + left_length +1, p_end, index+1, i_end);
        return root;
    }



    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};
        Leetcode105 l = new Leetcode105();

        System.out.println(TreeNode.layerTraversal(l.buildTree(preorder, inorder)));
    }
}
