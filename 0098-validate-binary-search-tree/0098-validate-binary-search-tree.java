
class BST_Pair {
    boolean isBST = true;
    long max = Long.MIN_VALUE;
    long min = Long.MAX_VALUE;
}


class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root).isBST;
    }
    
    public BST_Pair isValidBst(TreeNode root) {
        if (root == null) return new BST_Pair();
        BST_Pair left_bst_pair = isValidBst(root.left);
        BST_Pair right_bst_pair = isValidBst(root.right);
        BST_Pair self_bst_pair = new BST_Pair();
        self_bst_pair.max = Math.max(left_bst_pair.max,Math.max(right_bst_pair.max,root.val));
        self_bst_pair.min = Math.min(left_bst_pair.min,Math.min(right_bst_pair.min,root.val));
        self_bst_pair.isBST = left_bst_pair.isBST && right_bst_pair.isBST && left_bst_pair.max < root.val && right_bst_pair.min > root.val;
        return self_bst_pair;
    }
}
