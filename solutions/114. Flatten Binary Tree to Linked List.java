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
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        
        if(root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            
            TreeNode cr = root.right;
            while(cr.right != null) {
                cr = cr.right;
            }
            cr.right = temp;
        }
        
        flatten(root.right);
    }
}
