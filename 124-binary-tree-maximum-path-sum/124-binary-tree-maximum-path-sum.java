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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    private int maxSum(TreeNode root) {
        if(root == null) return 0;
        int left_sum = Math.max(0,maxSum(root.left));
        int right_sum = Math.max(0,maxSum(root.right));
        max = Math.max(left_sum + right_sum + root.val,max);
        return root.val + Math.max(left_sum,right_sum);
    }
}