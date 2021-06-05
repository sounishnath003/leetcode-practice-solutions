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
    private int finalDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        this._diameterOfBinaryTree(root);
        return this.finalDiameter;
    }
    
    private int _diameterOfBinaryTree(TreeNode root) {
        
        if (root == null)
            return -1;
        
        // faith
        int leftHeight = this._diameterOfBinaryTree(root.left);
        int rightHeight = this._diameterOfBinaryTree(root.right);
        
        int mydiameter = leftHeight + rightHeight + 2;
        
        // updating global max
        finalDiameter = Math.max(mydiameter, finalDiameter);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
