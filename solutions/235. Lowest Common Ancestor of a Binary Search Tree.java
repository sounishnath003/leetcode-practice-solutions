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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
​
        // to solve this problem we need to get the node to root path of both p and q
        // if p and q are on the same side of root, then LCA is root
​
        // find the node p
        List<TreeNode> nodepathP = find(root, p);
        // find the node q
        List<TreeNode> nodepathQ = find(root, q);
​
        TreeNode result = null;
​
        int i = nodepathP.size() - 1;
        int j = nodepathQ.size() - 1;
​
        while (ensureNotOutOfBound(i, j) && matchBothNode(nodepathP, nodepathQ, i, j)) {
            result = nodepathP.get(i);
            i--;
            j--;
        }
​
        return result;
    }
​
    private boolean matchBothNode(List<TreeNode> nodepathP, List<TreeNode> nodepathQ, int i, int j) {
        return nodepathP.get(i) == nodepathQ.get(j);
    }
​
    private boolean ensureNotOutOfBound(int i, int j) {
        return i >= 0 && j >= 0;
    }
​
    private List<TreeNode> find(TreeNode root, TreeNode node) {
​
        if (root == null)
            return new ArrayList<>();
​
        if (root.val == node.val) {
            List<TreeNode> bbres = new ArrayList<TreeNode>();
            bbres.add(node);
​
            return bbres;
        }
​
        List<TreeNode> nodepath = new ArrayList<TreeNode>();
​
        // faith
        List<TreeNode> rresFromLeft = find(root.left, node);
        if (rresFromLeft.size() > 0) {
            return addIfNodeFound(root, nodepath, rresFromLeft);
        }
​
        List<TreeNode> rresFromRight = find(root.right, node);
        if (rresFromRight.size() > 0) {
            return addIfNodeFound(root, nodepath, rresFromRight);
        }
​
        return nodepath;
    }
​
    private List<TreeNode> addIfNodeFound(TreeNode root, List<TreeNode> nodepath, List<TreeNode> rresFromLeft) {
        nodepath.addAll(rresFromLeft);
        nodepath.add(root);
        return nodepath;
    }
}
