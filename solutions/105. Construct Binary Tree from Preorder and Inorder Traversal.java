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
​
// Hopefully It Works!! [Random pickup]
​
class Solution {
    HashMap<Integer, Integer> hasmap = new HashMap<Integer, Integer>();
    int previousIndex = 0;
​
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            hasmap.put(inorder[i], i);
​
        return _buildTree(preorder, inorder, 0, inorder.length - 1);
    }
​
    private TreeNode _buildTree(int[] preorder, int[] inorder, int curIndex, int end) {
        // TODO Auto-generated method stub
​
        if (curIndex > end)
            return null;
​
        // creating root
        TreeNode root = new TreeNode(preorder[this.previousIndex]);
        this.previousIndex++;
​
        if (root == null || curIndex == end)
            return root;
​
        int idx = this.hasmap.get(root.val);
​
        // faith
        root.left = _buildTree(preorder, inorder, curIndex, idx - 1);
        root.right = _buildTree(preorder, inorder, idx + 1, end);
​
        return root;
    }
}
