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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        calculateCoin(root);
        return moves;
    }
    public int calculateCoin(TreeNode root) {
        if(root == null) return 0;
        int left = calculateCoin(root.left);
        int right = calculateCoin(root.right);
        moves += Math.abs(left) + Math.abs(right);
        int coins = left + right + root.val - 1;
        return coins;
    }
}