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
​
class Solution {
    private int maxSum = Integer.MIN_VALUE;
​
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
​
        _maxPathSum(root);
        return this.maxSum;
    }
​
    private int _maxPathSum(TreeNode root) {
​
        if (root == null)
            return 0;
        
        // faith
        int leftSum = Math.max(0, this._maxPathSum(root.left));
        int rightSum = Math.max(0, this._maxPathSum(root.right));
​
        int mysum = root.val + leftSum + rightSum;
​
        this.maxSum = Math.max(this.maxSum, mysum);
​
        return Math.max(leftSum, rightSum) + root.val;
    }
}
