class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return createTree(inorder,0,inorder.length - 1,preorder,0,preorder.length - 1);
        }
        private TreeNode createTree(int[] inorder,int ilo,int ihi,int[] preorder,int plo,int phi) {
           if(ilo > ihi || plo > phi) return null;
            TreeNode newNode = new TreeNode(preorder[plo]);
            int index = linearSearch(inorder,ilo,ihi,preorder[plo]);
            int net = index - ilo;
            newNode.left = createTree(inorder,ilo,index - 1,preorder,plo + 1,plo + net);
            newNode.right = createTree(inorder,index + 1,ihi,preorder,plo + net + 1,phi);
            return newNode;
        }
        public int linearSearch(int[] arr,int start,int end,int item) {
            for(int i = start; i <= end; i++)
            {
                if(arr[i] == item) return i;
            }
            return -1;
        }
    }