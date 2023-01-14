class Solution {
    private static class UnionFind {
        private int[] parent = new int[27];
​
        UnionFind() {
            for (int u = 0; u < parent.length; u++)
                parent[u] = u;
        }
​
        public void union(int u, int v) {
            int pa = find(u);
            int pb = find(v);
            // finds the smaller character as parent
            if (pa > pb) {
                parent[pa] = pb;
            } else {
                parent[pb] = pa;
            }
        }
​
        public int getparent(int u) {
            return find(u);
        }
​
        private int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }
    }
​
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < s1.length(); i++) {
            int u = (int) (s1.toCharArray()[i] - 'a');
            int v = (int) (s2.toCharArray()[i] - 'a');
            unionFind.union(u, v);
        }
        StringBuilder sb = new StringBuilder();
        for (char bchar : baseStr.toCharArray()) {
            int code = (int) (bchar - 'a');
            char ccode = (char) ((int) 'a' + unionFind.getparent(code));
            sb.append(ccode);
        }
        return sb.toString();
    }
}
