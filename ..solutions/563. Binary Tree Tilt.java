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
    int overall_tilt = 0;
    public int findTilt(TreeNode root) {
        _findTilt(root);
        return this.overall_tilt;
    }
    public int _findTilt(TreeNode root) {
        if (root == null)
            return 0;
        
        // faith
        int left_sum = this._findTilt(root.left);
        int right_sum = this._findTilt(root.right);
        
        int mysum = root.val + left_sum + right_sum;
        this.overall_tilt += Math.abs(left_sum - right_sum);
        
        return mysum;
    }
}
