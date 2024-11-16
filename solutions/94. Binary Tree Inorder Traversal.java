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
    public List<Integer> inorderTraversal(TreeNode root) {
        // implements the morris traversal algorithm
        List<Integer> nodes=new ArrayList<>();

        TreeNode current=root;
        while (current != null) {
            // something to be checked?
            // check if the node has left child
            if (current.left != null) {
                // goto the leftchild and traverse all right nodes till end
                TreeNode temp=current.left;
                // traverse until you hit the following cond.
                while (temp.right != null && temp.right != current) {
                    temp=temp.right;
                }
                // identify why it breaked
                if (temp.right == null) {
                    temp.right=current;
                    current=current.left;
                } else {
                    temp.right = null;
                    nodes.add(current.val);
                    current=current.right;
                }
            } else {
                // it has no left child
                // add the current in ndoes list
                nodes.add(current.val);
                // move to the right child
                current=current.right;
            }
        }

        return nodes;
    }
}
