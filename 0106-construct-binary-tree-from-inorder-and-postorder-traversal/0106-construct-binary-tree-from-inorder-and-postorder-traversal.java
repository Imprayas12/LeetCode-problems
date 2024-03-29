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
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return createTree(inorder,0,inorder.length - 1, postorder, 0, postorder.length - 1);   
    }
    private TreeNode createTree(int[] inorder,int inLow,int inHigh,int[] postorder,int poLow,int poHigh) {
        if(inLow > inHigh || poLow > poHigh) return null;
        TreeNode newNode = new TreeNode(postorder[poHigh]);
        int index = map.get(postorder[poHigh]);
        int netElements = index - inLow;
        newNode.left = createTree(inorder,inLow,index - 1,postorder,poLow,poLow + netElements - 1);
        newNode.right = createTree(inorder,index + 1,inHigh,postorder,poLow + netElements,poHigh - 1);
        return newNode;
    }
}