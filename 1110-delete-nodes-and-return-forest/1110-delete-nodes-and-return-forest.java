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
    List<TreeNode> ans = new ArrayList<>();
    Set<Integer> to_be_deleted;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_be_deleted = new HashSet<>();
        for(int i: to_delete) to_be_deleted.add(i);
        helper(root,true);
        return ans;
    }
    private TreeNode helper(TreeNode root,boolean isRoot) {
        if(root == null) return null;
        if(isRoot && !to_be_deleted.contains(root.val)) ans.add(root);
        boolean isDeleted = to_be_deleted.contains(root.val);
        root.left = helper(root.left, isDeleted);
        root.right = helper(root.right, isDeleted);
        return isDeleted ? null: root;
    }
}