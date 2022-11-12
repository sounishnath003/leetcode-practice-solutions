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
    private TreeNode previousNode = null;
    private int minimumSoFar = Integer.MAX_VALUE;
​
    public int minDiffInBST(TreeNode root) {
        if (root.left != null)
            this.minDiffInBST(root.left);
        if (previousNode != null) this.minimumSoFar = Math.min(this.minimumSoFar, root.val - previousNode.val);
        this.previousNode = root;
        if (root.right != null)
            this.minDiffInBST(root.right);
        return this.minimumSoFar;
    }
}
