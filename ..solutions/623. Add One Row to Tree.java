class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
         if(depth == 1)
         {
             TreeNode newRoot = new TreeNode(val, root, null);
             return newRoot;
         }
        
        helper(root, val, depth-1);
        
        return root;
    }
    
    public void helper(TreeNode root, int val, int depth)
    {
        if(root == null)
        {
            return;
        }
        
        if(depth == 1)
        {
            TreeNode newLeftTree = new TreeNode(val, root.left, null);
            TreeNode newRightTree = new TreeNode(val, null, root.right);
            root.left = newLeftTree;
            root.right = newRightTree;
             return;
        }
        
        helper(root.left, val, depth-1);
        helper(root.right, val, depth-1);
    }
}
