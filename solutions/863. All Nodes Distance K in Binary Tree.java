/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
​
class Solution {
​
    private List<Integer> nodesAtKDistance;
​
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.nodesAtKDistance = new ArrayList<>();
​
        ArrayList<TreeNode> rootpath = this.getTheNodeRootPath(root, target);
​
        for (int i = 0; i < rootpath.size(); i++) {
            TreeNode node = rootpath.get(i);
            if (i == 0) {
                this.printNodesWhichAreKLevelsDown(node, k-i, null);
            } else {
                this.printNodesWhichAreKLevelsDown(node, k-i, rootpath.get(i-1));
            }
        }
​
        return this.nodesAtKDistance;
    }
​
    private void printNodesWhichAreKLevelsDown(TreeNode node, int k, TreeNode blocker) {
​
        if (node == null || node == blocker || k < 0)
            return;
​
        if (k == 0) {
            nodesAtKDistance.add(node.val);
            return;
        }
​
        // faith
        this.printNodesWhichAreKLevelsDown(node.left, k - 1, blocker); // left call
        this.printNodesWhichAreKLevelsDown(node.right, k - 1, blocker); // right call
    }
​
    private ArrayList<TreeNode> getTheNodeRootPath(TreeNode root, TreeNode target) {
​
        if (root == null)
            return new ArrayList<>();
​
        if (root == target) {
            ArrayList<TreeNode> bres = new ArrayList<>();
            bres.add(root);
            return bres;
        }
​
        // faith
        ArrayList<TreeNode> path1 = this.getTheNodeRootPath(root.left, target);
        ArrayList<TreeNode> path2 = this.getTheNodeRootPath(root.right, target);
​
        ArrayList<TreeNode> mypath = new ArrayList<>();
​
        if (path1.size() > 0) {
            mypath = (ArrayList) path1.clone();
            mypath.add(root);
        } else if (path2.size() > 0) {
            mypath = (ArrayList) path2.clone();
            mypath.add(root);
        }
​
        return mypath;
    }
​
}
