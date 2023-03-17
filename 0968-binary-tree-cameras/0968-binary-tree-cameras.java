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
    final int covered = 1;
    final int required = -1;
    final int cameraFit = 2;
    public int minCameraCover(TreeNode root) {
        int c = CountCamera(root);
        if(c == -1) count++;
        return count;
    }
    public int CountCamera(TreeNode root) {
        if(root == null) return covered;
        int left = CountCamera(root.left);
        int right = CountCamera(root.right);
        if(left == required || right == required) {
            count += 1;
            return cameraFit;
        }
        if(left == covered && right == covered) return required;
        else return covered;
    }
    
    //1 -> Covered
    //-1 -> Required/ Not covered
    //2 -> Fit camera
}