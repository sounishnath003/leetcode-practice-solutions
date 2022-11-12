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
    private final Map<Integer, Integer> inorderRoots = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _buildTree(preorder, inorder);
    }
    
    private TreeNode _buildTree(int[] preorder, int[] inorder) {
        processInorderNodes(inorder);
        TreeNode root = constructFromPreoderInorder(preorder, 0, 0, inorder.length - 1);
        return root;
    }
​
    private  void processInorderNodes(int[] inorder) {
        for (int index = 0; index < inorder.length; index++) inorderRoots.put(inorder[index], index);
    }
​
    private TreeNode constructFromPreoderInorder(int[] preorder, int currentIndex, int lo, int hi) {
        if (lo > hi) return null;
​
        TreeNode root = new TreeNode(preorder[currentIndex]);
        if (root == null || lo == hi) return root;
​
        currentIndex++;
        int rootIndex = inorderRoots.get(root.val);
​
        root.left = constructFromPreoderInorder(preorder, currentIndex, lo, rootIndex - 1);
        root.right = constructFromPreoderInorder(preorder, currentIndex, rootIndex + 1, hi);
​
        return root;
    }
​
}
