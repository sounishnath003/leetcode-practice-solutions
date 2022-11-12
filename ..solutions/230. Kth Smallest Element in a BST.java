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
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = kth(root, k);
        return node.val;
    }
    
    // with Constant Space -- O(1), TC = O(height)
    private TreeNode kth(TreeNode root, int k) {
        
        if (root == null) return null;
        
        // faith
        TreeNode rl = kth(root.left, k);
        if (rl != null) return rl;
        
        this.count++;
        if (count == k) return root;
        
        TreeNode rr = kth(root.right, k);
        if (rr != null) return rr;
        
        return null;
    }
    
     /*
        jekono BST te inorder traverse korlei to sorted order pawa jai.
        question ta meaning less, but practice concepts of BST
        
        inorder traverse korbo - automatic asc order node pabo,
        simply nodes.get(k-1) korlei asha kori hye jabe!
    */
    private static ArrayList<Integer> nodes = new ArrayList<>();
    public int kthSmallest2(TreeNode root, int k) {
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
