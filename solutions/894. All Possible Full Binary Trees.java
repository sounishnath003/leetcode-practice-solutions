
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();

        /**
         * Idea to solve the solution, **Recursion**:
         * 1. For each node, we can have 0 or 2 children. to satisfy the full binary
         * tree condition.
         * 2. So, we can have 1 node and 0 children or 1 node and 2 children.
         * 
         * the recurrence relation is: (we need to return the TreeNode)
         * 
         * f(n) {
         * for (int i = 1; i < n; i += 2) {
         * List<TreeNode> left = f(i);
         * List<TreeNode> right = f(n - i - 1);
         * for (TreeNode l : left) {
         * for (TreeNode r : right) {
         * TreeNode root = new TreeNode(0);
         * root.left = l;
         * root.right = r;
         * res.add(root);
         * }
         */

        // if n is even, then we can't have full binary tree
        if (n % 2 == 0) {
            return res;
        }

        // if n is 1, then we can have only 1 node
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        // for each node, we can have 0 or 2 children
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0); // default value
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
