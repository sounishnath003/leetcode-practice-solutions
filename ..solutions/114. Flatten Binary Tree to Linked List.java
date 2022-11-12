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
    private boolean isleafnode(TreeNode root) {return (root.left == null && root.right == null) ; }
    private boolean hasLeft(TreeNode root) {return (root.left != null) ; }
    
    public void flatten(TreeNode root) {
        if (root == null || isleafnode(root)) {
            return ;
        }
        
        // self
        if (hasLeft(root)) {
            TreeNode rootright = root.right;
            root.right = root.left;
            root.left = null;
            
            TreeNode temp = root.right;
            while (temp.right != null) temp = temp.right;
            temp.right = rootright;
        }
        
        // faith
        flatten(root.right);
        
    }
}
