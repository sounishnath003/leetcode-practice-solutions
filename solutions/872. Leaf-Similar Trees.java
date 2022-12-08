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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        /*
         * store all the nodes of indivisual tree and compare
         */
        return preorder(root1).equals(preorder(root2));
    }
​
    private String preorder(TreeNode root) {
        // TODO Auto-generated method stub
        if (root == null)
            return "";
        if (isLeaf(root))
            return "-" + root.val + "-";
        String left = preorder(root.left);
        String right = preorder(root.right);
        return left + right;
    }
​
    private boolean isLeaf(TreeNode root) {
        // TODO Auto-generated method stub
        return (root != null && root.left == null && root.right == null);
    }
}
​
