/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        Set<TreeNode> vis = new HashSet<>();
        vis.add(target);
        vis.add(null);
        int dist = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                if(dist == k) {
                    List<Integer> ans = new LinkedList<>();
                    for(TreeNode n: queue) {
                        ans.add(n.val);
                    }
                    return ans;
                }
                dist += 1;
                queue.offer(null);
            }
            else {
                if(!vis.contains(node.left)) {
                    vis.add(node.left);
                    queue.offer(node.left);
                }
                if(!vis.contains(node.right)) {
                    vis.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode p = map.get(node);
                if(!vis.contains(p)) {
                    vis.add(p);
                    queue.offer(p);
                }
            }
        }
        return new LinkedList<>();
    }
    private void dfs(TreeNode root, TreeNode parent) {
        if(root != null){
            map.put(root, parent);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}