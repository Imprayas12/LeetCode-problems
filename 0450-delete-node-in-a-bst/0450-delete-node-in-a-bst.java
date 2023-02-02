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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            int maximum = max(root.left);
            root.left = deleteNode(root.left, maximum);
            root.val = maximum;
        }
        if(root.val < key) {
            root.right = deleteNode(root.right,key);
        }
        else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
    public int min(TreeNode root) {
        if(root == null) return 999999;
        int left = min(root.left);
        return Math.min(left,root.val);
    }
    public int max(TreeNode root) {
        if(root == null) return -999999;
        int right = max(root.right);
        return Math.max(right,root.val);
    }
}