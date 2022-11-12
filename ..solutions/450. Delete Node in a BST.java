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
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNode_(root, key);
    }
    
    TreeNode getDeepestRightChild(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }
​
    TreeNode deleteAndReorderTheSubtree(TreeNode root) {
        // if root does not have left return right and vice versa
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
​
        // copy the right subtree of the root
        TreeNode rightsubtree = root.right;
        TreeNode mostRightChild = getDeepestRightChild(root.left);
        mostRightChild.right = rightsubtree;
        return root.left;
    }
​
    TreeNode deleteNode_(TreeNode root, int target) {
        if (root == null) return root;
        
        // if root itself is target
        if (root.val == target) return deleteAndReorderTheSubtree(root);
​
        TreeNode temp = root;
        while (temp != null) {
            // find the target
            if (temp.val > target) {
                // go left
                // possible left is the target itself
                if (temp.left != null && temp.left.val == target) {
                    temp.left = deleteAndReorderTheSubtree(temp.left);
                    break;
                }
                else {
                    temp = temp.left;
                }
            } else {
                if (temp.right != null && temp.right.val == target) {
                    temp.right = deleteAndReorderTheSubtree(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
}
