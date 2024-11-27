​
class Solution {
    private int maxDepth=0;
    private TreeNode result=null;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findDepth(root, 0);
        return result;
    }
    
    private int findDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        
        // faith
        int leftHeight=findDepth(root.left, depth+1);
        int rightHeight=findDepth(root.right, depth+1);
        
        // my work
        if (leftHeight == rightHeight) {
            maxDepth=Math.max(maxDepth,leftHeight);
            if (maxDepth == leftHeight) {
                result=root;
            }
        }
        
        return Math.max(leftHeight, rightHeight);
    }
}
