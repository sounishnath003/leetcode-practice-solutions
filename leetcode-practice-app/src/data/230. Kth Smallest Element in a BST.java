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
    /*
        jekono BST te inorder traverse korlei to sorted order pawa jai.
        question ta meaning less, but practice concepts of BST
        
        inorder traverse korbo - automatic asc order node pabo,
        simply nodes.get(k-1) korlei asha kori hye jabe!
    */
    private static ArrayList<Integer> nodes = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        performInOrderTraversal(root);
        return nodes.get(k-1); // 0 based indexing
    }
    
    private static void performInOrderTraversal(TreeNode root) {
        if (root == null) return;
        performInOrderTraversal(root.left);
        nodes.add(root.val);
        performInOrderTraversal(root.right);
    }
}
