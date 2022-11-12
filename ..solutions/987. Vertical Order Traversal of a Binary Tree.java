class Solution {
    static class NodePair {
        int level;
        int horizontal_distance;
        TreeNode node;
        public NodePair(int level, int horizontal_distance, TreeNode node) {
            this.level = level;
            this.horizontal_distance = horizontal_distance;
            this.node = node;
        }
​
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<NodePair> queue = new LinkedList<>();
        queue.offer(new NodePair(0, 0, root));
        Map<Integer, TreeMap<Integer,PriorityQueue<TreeNode>>> node_map = new TreeMap<>(); // <HD, <LEVEL,NODEPAIR>>
​
        while (!queue.isEmpty()) {
            NodePair node = queue.poll();
            if (!node_map.containsKey(node.horizontal_distance)) {
                node_map.put(node.horizontal_distance, new TreeMap<>());
            } 
            if (!node_map.get(node.horizontal_distance).containsKey(node.level)) {
                node_map.get(node.horizontal_distance).put(node.level, new PriorityQueue<>((a, b) -> a.val - b.val ));
            }
            node_map.get(node.horizontal_distance).get(node.level).offer(node.node);
            if (node.node.left != null) {
                queue.offer(new NodePair(node.level+1, node.horizontal_distance-1, node.node.left));
            }
            if (node.node.right != null) {
                queue.offer(new NodePair(node.level+1, node.horizontal_distance+1, node.node.right));
            }
        }
​
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<TreeNode>> ys : node_map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<TreeNode> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll().val);
                }
            }
        }
        return list;
    }
}
