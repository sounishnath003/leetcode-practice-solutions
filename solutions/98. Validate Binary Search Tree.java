/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return simpleCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // return isBST(root).isbst;
    }

    boolean simpleCheck(TreeNode root, long start, long end) {
        if (root == null) return true ;

        if (start < root.val && root.val < end) {
            boolean leftTree = simpleCheck(root.left, start, root.val);
            boolean rightTree = simpleCheck(root.right, root.val, end);
            return leftTree && rightTree;
        }

        return false;
    }
    
    class State {
        int minimum;
        int maximum;
        boolean isbst;

        State() {
            this.minimum = Integer.MAX_VALUE;
            this.maximum = Integer.MIN_VALUE;
            this.isbst = true;
        }
        State(int min, int mx, boolean bst) {
            this.minimum = min;
            this.maximum = mx;
            this.isbst = bst;
        }
    }

    State isBST(TreeNode root) {
        if (root == null) return new State();
        
        // faith
        State left = isBST(root.left);
        State right = isBST(root.right);

        if (left.isbst == false || right.isbst == false) return new State(Integer.MAX_VALUE, Integer.MIN_VALUE, false); 

        boolean isbst = (left.maximum < root.val && root.val < right.minimum) ? true : false ;
        if (isbst == false) return new State(Integer.MAX_VALUE, Integer.MIN_VALUE, false);

        State state = new State();
        state.minimum = Math.min(left.minimum, right.minimum);
        state.maximum = Math.min(left.maximum, right.maximum);
        state.isbst = isbst;

        return state;
    }
}
