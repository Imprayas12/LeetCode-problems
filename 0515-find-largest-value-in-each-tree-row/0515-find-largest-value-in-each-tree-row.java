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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int s = queue.size();
            for(int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max,node.val);
                System.out.print(max + " ");
                if(node.left != null)
                queue.add(node.left);
                if(node.right != null)
                queue.add(node.right);
            }
            System.out.println(max);
            ans.add(max);
        }
        return ans;
    }
}