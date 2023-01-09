class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return morrisTraversal(root);
    }
    
    private List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        TreeNode current = root;
        while (current != null) {
            result.add(current.val);
            // check if left not null;
            if (current.left != null) {
                // goto rightmost child of current.left
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                // point temp.right to current.right to explore the right part
                temp.right = current.right;
                current.right = null; // to clear the references to duplicate remove
                current = current.left;
            } else {
                // means left is null, new current is current right
                current = current.right;
            }
        }
        
        
        return result;
    }
}
