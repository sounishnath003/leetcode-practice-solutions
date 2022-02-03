class Solution {
​
    class UnionFindAlgorithm {
        public static final int find (int node, int[] parent) {
            if (parent[node]==-1) {
                return node;
            } else {
                int rparent = find(parent[node], parent);
                parent[node] = rparent;
                return rparent;
            }
        }
​
        public static final void union(int u, int v, int[] parent) {
            int unode = find(u, parent);
            int vnode = find(v, parent);
​
            if (unode != vnode) {
                parent[vnode] = unode;
            }
        }
    }
​
    public int largestComponentSize(int[] nums) {
        int[] parent = new int[100005];
        Arrays.fill(parent, -1);
​
        for (int node : nums) {
                for (int i = 2; i <= (int) Math.sqrt(node); i++) {
                    if (node % i == 0) {
                        // means divisable
                        UnionFindAlgorithm.union(i, node, parent); // 20
                        UnionFindAlgorithm.union(node, (int) node/i, parent);
                    }
                }
        }
​
        // System.out.println(parent);
​
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
                int xp = UnionFindAlgorithm.find(x, parent);
                map.put(xp, map.getOrDefault(xp, 0) + 1 );
                answer = Math.max(answer, map.get(xp) );
        }
​
            return answer;
    }
}
