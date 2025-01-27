
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        // we have to use the BST property only

        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        }

        return root.val == val ? root : null;
    }
}