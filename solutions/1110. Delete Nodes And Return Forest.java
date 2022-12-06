class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int node : to_delete)
            deleteSet.add(node);
        List<TreeNode> forestNodes = new ArrayList<>();
        TreeNode somenode = solve(root, deleteSet, forestNodes);
        if (somenode != null)
            forestNodes.add(root);
        return forestNodes;
    }
​
    private TreeNode solve(TreeNode root, Set<Integer> deleteSet, List<TreeNode> forestNodes) {
        // TODO Auto-generated method stub
        if (root == null)
            return null;
​
        root.left = solve(root.left, deleteSet, forestNodes);
        root.right = solve(root.right, deleteSet, forestNodes);
​
        if (deleteSet.contains(root.val)) {
            if (root.left != null) {
                forestNodes.add(root.left);
            }
            if (root.right != null) {
                forestNodes.add(root.right);
            }
            return null;
        }
​
        return root;
    }
}
​
