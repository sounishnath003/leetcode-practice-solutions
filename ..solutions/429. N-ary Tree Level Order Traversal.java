class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;
        queue.add(root);
​
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level_list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node!=null) {
                    level_list.add(node.val);
                    // for all the childrens; push into queue
                    node.children.forEach((e) -> queue.add(e));
                }
            }
            if (level_list.size()>0)
                result.add(new ArrayList<>(level_list));
        }
        return result;
    }
}
