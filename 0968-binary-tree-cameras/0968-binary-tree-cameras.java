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
    int count = 0;
    public int minCameraCover(TreeNode root) {
        int c = CountCamera(root);
        if(c == -1) count++;
        return count;
    }
    public int CountCamera(TreeNode root) {
        if(root == null) return 1;
        int left = CountCamera(root.left);
        int right = CountCamera(root.right);
        if(left == -1 || right == -1) {
            count += 1;
            return 2;
        }
        if(left == 1 && right == 1) return -1;
        else return 1;
    }
    
    //1 -> Covered
    //-1 -> Required/ Not covered
    //2 -> Fit resume
}