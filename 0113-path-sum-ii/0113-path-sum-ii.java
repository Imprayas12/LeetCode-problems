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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(targetSum,root,ans,current);
        return ans;
    }
    private void dfs(int target, TreeNode node, List<List<Integer>> list,List<Integer> current) {
       if(node == null) return; 
       if(node.left == null && node.right == null) {
           if(target - node.val == 0) {
               current.add(node.val);
               list.add(new ArrayList<>(current));
               current.remove(current.size() - 1);
           }
           return;
       }
       current.add(node.val);
       dfs(target - node.val,node.left,list,current);
       dfs(target - node.val,node.right,list,current);
       current.remove(current.size() - 1);
    }
}