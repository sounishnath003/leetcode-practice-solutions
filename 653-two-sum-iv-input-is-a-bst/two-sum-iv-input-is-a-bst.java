
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        /*
         * Given the root of a binary search tree and an integer k, return true if there
         * exist two elements in the BST such that their sum is equal to k, or false
         * otherwise.
         */
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

}