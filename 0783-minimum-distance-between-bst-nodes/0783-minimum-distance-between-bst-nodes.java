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
    public int minDiffInBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root,vals);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < vals.size() - 1; i++) {
            diff = Math.min(vals.get(i + 1) - vals.get(i),diff);
        }
        return diff;
    }
    private void inorder(TreeNode root,List<Integer> vals) {
        if(root == null) return;
        inorder(root.left,vals);
        vals.add(root.val);
        inorder(root.right,vals);
    }
}