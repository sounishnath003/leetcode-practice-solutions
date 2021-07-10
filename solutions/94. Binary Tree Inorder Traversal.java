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
    private List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        _inorderTraversal(root);
        return result;
    }
​
    private void _inorderTraversal(TreeNode root) {
​
        if (root == null) {
            return ;
        }
        // faith
        _inorderTraversal(root.left);
        this.result.add(root.val);
        _inorderTraversal(root.right);
    }
}
