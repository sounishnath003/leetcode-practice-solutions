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
// SIMPLE ALGO EXPERT ADVERTISEMENT PROBLEM. LOL <3
// XD
​
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null ;
        
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
​
        root.left = rightTree;
        root.right = leftTree;
        
        return root;
    }
}
