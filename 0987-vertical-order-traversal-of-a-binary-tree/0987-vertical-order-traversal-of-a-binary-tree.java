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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        DFS(root,0,0,map);
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> x_coor: map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> y_coor: x_coor.values()){
                while(!y_coor.isEmpty()) {
                    ans.get(ans.size()-1).add(y_coor.poll());
                }
            }
        }
        return ans;
    }
    private void DFS(TreeNode root, int x_coor,int y_coor,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map) {
     if(root == null) return;
        
        if(!map.containsKey(x_coor)) {
            map.put(x_coor, new TreeMap<>());
        }
        if(!map.get(x_coor).containsKey(y_coor)) {
            map.get(x_coor).put(y_coor,new PriorityQueue<>());
        }
        map.get(x_coor).get(y_coor).add(root.val);
        DFS(root.left,x_coor - 1, y_coor + 1, map);
        DFS(root.right,x_coor + 1,y_coor + 1,map);
    }
}