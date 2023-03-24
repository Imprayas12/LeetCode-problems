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
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = l;
                    newNode.right = r;
                    list.add(newNode);
                }
            }
        }
        return list;
        
    }
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
}