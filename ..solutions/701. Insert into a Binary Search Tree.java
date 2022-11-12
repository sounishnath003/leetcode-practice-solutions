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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
    
    // TC: O(logN), SC: O(H)
    TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
​
        if (root.val > data) {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }
​
        return root;
    }
}
