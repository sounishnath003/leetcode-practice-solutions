/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return f(nums, 0, nums.length - 1);
    }

    private TreeNode f(int[] nums, int low, int end) {
        if (low > end) return null;

        // find the mid index
        int midI = (low + (end - low) / 2);
        TreeNode root = new TreeNode(nums[midI]);

        // my rule
        root.left = f(nums, low, midI - 1);
        root.right = f(nums, midI + 1, end);

        return root;
    }
}