class Solution {
    int sm = Integer.MIN_VALUE;;
​
    public int maxPathSum(TreeNode root) {
        solver(root);
        return sm;
    }
​
    private int solver(TreeNode root) {
        if (root == null) {
            return 0;
        }
​
        int leftsum = Math.max(0,solver(root.left));
        int rightsum = Math.max(0,solver(root.right));
​
        int mypathsum = leftsum + rightsum + root.val;
        this.sm = Math.max(this.sm, mypathsum);
        return Math.max(leftsum, rightsum) + root.val;
    }
}
