/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }
    private int height(TreeNode root,int[] diameter) {
        if(root == null) return 0;
        int left_tree = height(root.left,diameter);
        int right_tree = height(root.right,diameter);
        diameter[0] = Math.max(left_tree + right_tree,diameter[0]);
        return 1 + Math.max(left_tree,right_tree);
    }
}