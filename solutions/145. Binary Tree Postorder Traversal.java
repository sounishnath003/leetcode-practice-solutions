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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        func (root, nodes);
        return nodes;
    }
    
    private void func (TreeNode node, List<Integer> nodes) {
        if (node != null) {
            func (node.left, nodes);
            func (node.right, nodes);
            nodes.add (node.val);
        }
    }
}
