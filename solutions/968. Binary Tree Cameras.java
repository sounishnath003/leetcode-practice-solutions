​
class Solution {
int minimumCameras = 0;
    Set<TreeNode> covered = new HashSet<>(); // store the temp visited
    // Binary Tree Cameras | Live Coding with Explanation | Leetcode - 968
    // https://www.youtube.com/watch?v=2Gh5WPjAgJk
​
    public int minCameraCover(TreeNode root) {
        minimumCameras = 0;
        covered.add(null);
        minCameraCoverHelper(root, null);
        return minimumCameras;
    }
​
    public void minCameraCoverHelper(TreeNode root, TreeNode parent) {
        
        if (root == null) {
            return;
        }
​
        // faith
        minCameraCoverHelper(root.left, root);
        minCameraCoverHelper(root.right, root);
​
        // my work
        if (parent == null && !covered.contains(root)
                || !covered.contains(root.left)
                || !covered.contains(root.right)) {
            minimumCameras++;
            covered.add(parent);
            covered.add(root);
            covered.add(root.left);
            covered.add(root.right);
        }
    }
​
}
