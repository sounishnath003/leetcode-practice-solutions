class Solution {
    private static class Pair {
        TreeNode node;
        int level;
​
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
​
    public List<Integer> largestValues(TreeNode root) {
        // simply perform the level order traversal on the tree
        // store the vals into a sorted list set like TreeSet / PriorityQueue
        if (root==null) return new ArrayList<>();
        int level = 0;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, PriorityQueue<Integer>> pqMap = new TreeMap<>();
​
        queue.offer(new Pair(root, level));
        pqMap.putIfAbsent(level, new PriorityQueue<>(Comparator.reverseOrder()));
​
        // until my queue is not empty
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            for (int k = 0; k < qsize; k++) {
                Pair pairNode = queue.poll();
                pqMap.putIfAbsent(pairNode.level, new PriorityQueue<>(Comparator.reverseOrder()));
                pqMap.get(pairNode.level).add(pairNode.node.val);
                if (pairNode.node.left != null) {
                    queue.add(new Pair(pairNode.node.left, pairNode.level + 1));
                }
                if (pairNode.node.right != null) {
                    queue.add(new Pair(pairNode.node.right, pairNode.level + 1));
                }
            }
        }
​
        List<Integer> levelMaximumList = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> kv : pqMap.entrySet()) {
            int levelMax = kv.getValue().poll();
            levelMaximumList.add(levelMax);
        }
​
        return levelMaximumList;
    }
}
