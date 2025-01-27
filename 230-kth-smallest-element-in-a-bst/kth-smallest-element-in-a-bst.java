class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest2(root,k).val;
    }

    private int count=0;
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    public TreeNode kthSmallest2(TreeNode root, int k) {
        /*
         * Given the root of a binary search tree, and an integer k, return the kth
         * smallest value (1-indexed) of all the values of the nodes in the tree.
         */

        if(root == null) {
            return null;
        }

        // inorder traversal only
        TreeNode left=kthSmallest2(root.left, k);
        if (left!=null) return left;

        this.count++;
        if(this.count==k) return root;

        TreeNode right=kthSmallest2(root.right, k);
        if (right!=null) return right;

        return null;
    }
}