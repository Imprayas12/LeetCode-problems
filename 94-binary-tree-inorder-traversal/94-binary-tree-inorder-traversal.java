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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> HF = new ArrayList<>();
        recur(root,HF);
        return HF;
    }
    static void recur(TreeNode root,List<Integer> HF){
        if(root!=null){
            recur(root.left,HF);
            HF.add(root.val);
            recur(root.right,HF);
        }
    }
}