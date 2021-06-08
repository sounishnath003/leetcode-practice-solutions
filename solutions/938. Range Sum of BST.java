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
    private int sum = 0;
​
    public int rangeSumBST(TreeNode root, int low, int high) {
        _rangeSumBST(root, low, high);
        return this.sum;
    }
​
    public void _rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return;
​
        int data = root.val;
        // faith
        if (data >= low)
            _rangeSumBST(root.left, low, high);
​
        if (data >= low && data <= high)
            sum += data;
​
        if (data <= high)
            _rangeSumBST(root.right, low, high);
    }
}
