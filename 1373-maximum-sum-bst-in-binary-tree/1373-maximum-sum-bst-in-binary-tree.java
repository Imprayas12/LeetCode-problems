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
class Info {
    int sum;
    int max;
    int min;
    int ans;
    boolean isBST;
    Info() {

    }
    Info(int sum, int max, int min, int ans, boolean isBST) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.ans = ans;
        this.isBST = isBST;
    }
}
class Solution {
    public int maxSumBST(TreeNode root) {
        int ans = largestBSTinBT(root).ans;
        return ans < 0 ? 0 : ans;
    }
    private Info largestBSTinBT(TreeNode root) {
		if(root == null) {
			return new Info(0,Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
		}
		Info left = largestBSTinBT(root.left);
		Info right = largestBSTinBT(root.right);
        Info self = new Info();
        self.max = Math.max(left.max,Math.max(right.max,root.val));
	    self.min = Math.min(left.min,Math.min(right.min,root.val));
        self.isBST = left.isBST && right.isBST && root.val > left.max && root.val < right.min;
        if(self.isBST) {
            self.sum = left.sum + right.sum + root.val;
            self.ans = Math.max(self.sum,Math.max(left.ans,right.ans));
        }
        else {
            self.sum = 0;
            self.ans = Math.max(left.ans,right.ans);
        }
		return self;
	}
}