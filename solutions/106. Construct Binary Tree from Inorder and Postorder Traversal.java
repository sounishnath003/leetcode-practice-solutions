/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = inorder.length-1;
        return constructTree(0, postorder.length-1, inorder, postorder);
    }
    public TreeNode constructTree(int start, int end, int[] inorder, int[] postorder) {
        if (start>end) return null;
        TreeNode root = new TreeNode(postorder[idx--]);
        int i;
        for (i = start; i <= end; i++) {
            if (root.val==inorder[i]) {
                break;
            }
        }
        root.right = constructTree(i+1, end, inorder, postorder);
        root.left = constructTree(start, i-1, inorder, postorder);
        return root;
    }
}
