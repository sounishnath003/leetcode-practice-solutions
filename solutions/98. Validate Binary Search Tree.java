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
    class Pair3 {
        int min;
        int max;
        boolean state;
​
        Pair3() {
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.state = true;
        }
​
        Pair3(int min, int max, boolean status) {
            this.min = min;
            this.max = max;
            this.state = status;
        }
    }
​
    public boolean isValidBST(TreeNode root) {
        Pair3 ans = _isValidBST(root);
        return ans.state;
    }
​
    private Pair3 _isValidBST(TreeNode root) {
​
        if (root == null) {
            return new Pair3();
        }
​
        // faith
        Pair3 left_result = _isValidBST(root.left);
        Pair3 right_result = _isValidBST(root.right);
​
        // self work
​
        Pair3 mystatus = new Pair3();
​
        if (root.val <= left_result.max || root.val > right_result.min)
            mystatus.state = false;
​
        mystatus.min = Math.min(root.val, Math.min(left_result.min, right_result.min));
        mystatus.max = Math.max(root.val, Math.max(left_result.max, right_result.max));
​
        return mystatus;
    }
}
