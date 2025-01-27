
class Solution {
    private int pi = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder, int minVal, int maxVal) {

        if (pi >= preorder.length || preorder[pi] > maxVal || preorder[pi] < minVal)
            return null;

        TreeNode node = new TreeNode(preorder[pi++]);

        node.left = bstFromPreorder(preorder, minVal, node.val);
        node.right = bstFromPreorder(preorder, node.val, maxVal);

        return node;
    }

}