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
    int curindx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return _bst_construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
​
    private TreeNode _bst_construct(int[] preorder, int minValue, int maxValue) {
​
        if (curindx >= preorder.length ||
                preorder[curindx] > maxValue || preorder[curindx] < minValue) return null;
​
        TreeNode node = new TreeNode(preorder[curindx++]);
​
        node.left = _bst_construct(preorder, minValue, node.val);
        node.right = _bst_construct(preorder, node.val, maxValue);
​
        return node;
    }
}
