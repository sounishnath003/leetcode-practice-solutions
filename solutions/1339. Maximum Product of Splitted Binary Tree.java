class Solution {
    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
​
        long totalSum = getTotalSum(root);
        long[] maxsum = new long[] { Integer.MIN_VALUE };
        runForEachNodeAndUpdateTotalSum(root, totalSum, maxsum);
        return (int) (maxsum[0] % (int) (1e9 + 7));
    }
​
    private long runForEachNodeAndUpdateTotalSum(TreeNode root, long totalSum, long[] maxsum) {
        // TODO Auto-generated method stub
        if (root == null) {
            return 0;
        }
​
        long leftsum = runForEachNodeAndUpdateTotalSum(root.left, totalSum, maxsum);
        long rightsum = runForEachNodeAndUpdateTotalSum(root.right, totalSum, maxsum);
​
        long temp = leftsum + rightsum + root.val;
        long probableAnswer = temp * (totalSum - temp);
        maxsum[0] = Math.max(maxsum[0], probableAnswer);
​
        return temp;
    }
​
    private long getTotalSum(TreeNode root) {
        // TODO Auto-generated method stub
        if (root == null)
            return 0;
        return (long) (getTotalSum(root.left) + root.val + getTotalSum(root.right));
    }
}
​
