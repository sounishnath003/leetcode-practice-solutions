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
    public int maxAncestorDiff(TreeNode root) {
        return _solver(root, root.val, root.val);
    }
​
    private int _solver(TreeNode root, int low, int high) {
        // TODO Auto-generated method stub
        if (root == null) {
            return Math.abs(high - low);
        }
​
        low = Math.min(low, root.val);
        high = Math.max(high, root.val);
        int a1 = _solver(root.left, low, high);
        int a2 = _solver(root.right, low, high);
​
        return Math.max(a1, a2);
    }
​
    public int maxAncestorDiff2(TreeNode root) {
        if (root == null)
            return 0;
​
        int maxdiff1 = helper(root.left, root.val);
        int maxdiff2 = helper(root.right, root.val);
​
        int ma = Math.max(maxAncestorDiff2(root.left), maxAncestorDiff2(root.right));
​
        return Math.max(ma, Math.max(maxdiff1, maxdiff2));
    }
​
    private int helper(TreeNode root, int a) {
        // TODO Auto-generated method stub
        if (root == null)
            return 0;
​
        int diff1 = helper(root.left, a);
        int diff2 = helper(root.right, a);
        int mydiff = Math.abs(root.val - a);
        return Math.max(mydiff, Math.max(diff1, diff2));
    }
}
​
