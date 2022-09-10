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
    public int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
     maxSum(root,sum);
        return sum[0];
    }
    private int maxSum(TreeNode root,int[] dist) {
        if(root == null) return 0;
        int left_sum = Math.max(0,maxSum(root.left,dist));
        int right_sum = Math.max(0,maxSum(root.right,dist));
        dist[0] = Math.max(left_sum + right_sum + root.val,dist[0]);
        return root.val + Math.max(left_sum,right_sum);
    }
}