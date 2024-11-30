class Solution {
​
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Prepare the parent map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        findAllParent(root, parentMap, null);
​
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        findKDistanceNodes(target, parentMap, visited, result, k, 0);
​
        return result;
    }
​
    private void findAllParent(TreeNode root, Map<TreeNode, TreeNode> parentMap, TreeNode parent) {
        if (root == null) return;
​
        parentMap.put(root, parent);
        findAllParent(root.left, parentMap, root);
        findAllParent(root.right, parentMap, root);
    }
​
    private void findKDistanceNodes(TreeNode node, Map<TreeNode, TreeNode> parentMap,
                                    Set<TreeNode> visited, List<Integer> result, int k, int depth) {
        if (node == null || visited.contains(node)) {
            return;
        }
​
        // Mark the current node as visited
        visited.add(node);
​
        // If we reach the target depth, add the node's value to the result
        if (depth == k) {
            result.add(node.val);
            return;
        }
​
        // Explore left child
        findKDistanceNodes(node.left, parentMap, visited, result, k, depth + 1);
​
        // Explore right child
        findKDistanceNodes(node.right, parentMap, visited, result, k, depth + 1);
​
        // Explore parent
        TreeNode parent = parentMap.get(node);
        findKDistanceNodes(parent, parentMap, visited, result, k, depth + 1);
    }
}
​
