
class Solution {
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    // https://www.youtube.com/watch?v=NOKVBiJwkD0
    public void flatten(TreeNode root) {
        flattenUsingMorris(root) ;
        
        // TC : O(N)
        // SPACE : O(H)
        // TODO: shall be implementing in sometime.

        // if (root == null || isLeafNode(root))
        //     return;

        // TreeNode tempLeft = root.left;
        // TreeNode tempRight = root.right;

        // // faith
        // flatten(root.left);
        // flatten(root.right);

        // // my work
        // root.right = tempLeft;
        // root.left = null;

        // TreeNode current = root;
        // while (current.right != null)
        //     current = current.right;
        // current.right = tempRight;

        // return;
    }

    public void flattenUsingMorris(TreeNode root) {
        // TC: O(N)
        // SC: O(1)
        
        if (root == null || isLeafNode(root)) return;
        TreeNode current = root;

        while (current != null) {
            // has left
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                
                current.right = current.left;
                current.left=null;
                
                current=current.right;
            } else {
                current = current.right;
            }
        }
    }

    private boolean isLeafNode(TreeNode root) {
        // TODO Auto-generated method stub
        return root.left == null && root.right == null;
    }
}