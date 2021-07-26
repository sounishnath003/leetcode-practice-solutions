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
    public TreeNode sortedArrayToBST(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
​
        TreeNode root = this.sortedArrayToBST(nums, lo, hi);
        return root;
    }
​
    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        
        if (lo == hi) return new TreeNode(nums[lo]);
​
        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
​
        // faith
        node.left = this.sortedArrayToBST(nums, lo, mid - 1);
        node.right = this.sortedArrayToBST(nums, mid + 1, hi);
​
        return node;
    }
}
