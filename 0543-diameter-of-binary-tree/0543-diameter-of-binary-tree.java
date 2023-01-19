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
    public class Dia_Pair {
        int height = -1;
        int diameter = 0;
    }
    public int diameterOfBinaryTree(TreeNode root) {
            return diameter(root).diameter;
        }
        public Dia_Pair diameter(TreeNode root) {
            if(root == null) {
                return new Dia_Pair();
            }
            Dia_Pair left_dia_pair = diameter(root.left);
            Dia_Pair right_dia_pair = diameter(root.right);
            Dia_Pair self_dia_pair = new Dia_Pair();
            int self_dia = left_dia_pair.height + right_dia_pair.height + 2;
            self_dia_pair.diameter = 
            Math.max(left_dia_pair.diameter,Math.max(right_dia_pair.diameter,self_dia));
            self_dia_pair.height = Math.max(left_dia_pair.height,right_dia_pair.height) + 1;
            return self_dia_pair;
        }
}