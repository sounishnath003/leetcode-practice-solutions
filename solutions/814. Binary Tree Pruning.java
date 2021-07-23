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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.left!=null || root.right!=null || root.val==1)
            return root;
        return null;
    }
    
    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) return null;
        this.containsOne(root);
        return root;
    }
​
    private boolean containsOne(TreeNode root) {
        if (root == null) return false;
​
        // faith
        boolean rrleft = this.containsOne(root.left);
        boolean rrright = this.containsOne(root.right);
​
        if (rrleft == false) root.left = null; // meaning deleting whole left subtree
        if (rrright == false) root.right = null; // // meaning deleting whole right subtree
​
        int myval = root.val;
        boolean mystatus = myval == 1;
​
        return mystatus || rrleft || rrright; // because either one will work for us
    }
}
