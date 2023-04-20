/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode  left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.index = index;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int res = 1;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()) {
            int s = queue.size();
            int end = queue.peekLast().index;
            int start = queue.peekFirst().index;
            res = Math.max(res, end - start + 1);
            for(int i = 0; i < s; i++) {
                Pair p = queue.poll();
                int idx = p.index - start;
                if(p.node.left != null) queue.add(new Pair(p.node.left, 2 * idx + 1));
                if(p.node.right != null) queue.add(new Pair(p.node.right, 2 * idx + 2));
            }
        }
        return res;
    }
}