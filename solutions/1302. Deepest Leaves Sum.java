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
    private int globalsum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int height = getHeight(root); 
        _deepestLeavesSum(root, height, 0);
        return globalsum;
    }
    private int getHeight(TreeNode root) {
        
        if (root == null) return -1;
        
        // faith
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        return Math.max(lh, rh) + 1;
    }
    
    private int _deepestLeavesSum(TreeNode root, int height, int curlevel) {
        if (root == null) return 0;
        
        if (curlevel == height && root.left == null && root.right == null) {
            globalsum += root.val;
            return root.val;
        }
        
        // faith
        int leftLeaveSum = _deepestLeavesSum(root.left, height, curlevel + 1);
        int rightLeaveSum = _deepestLeavesSum(root.right, height, curlevel + 1);
        
        int myres = leftLeaveSum + rightLeaveSum;
        return myres;
    }
}
