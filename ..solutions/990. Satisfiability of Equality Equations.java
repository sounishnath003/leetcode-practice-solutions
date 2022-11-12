class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
​
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                int x = equations[i].charAt(0) - 'a';
                int y = equations[i].charAt(3) - 'a';
​
                int leader_x = find_leader(parent, x);
                int leader_y = find_leader(parent, y);
                
                System.out.println(leader_x + " - " + leader_y);
​
                if (leader_x == leader_y) continue;
                do_union(leader_x, leader_y, parent);
            }
        }
​
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                int x = equations[i].charAt(0) - 'a';
                int y = equations[i].charAt(3) - 'a';
​
                int leader_x = find_leader(parent, x);
                int leader_y = find_leader(parent, y);
​
                if (leader_x == leader_y) return false;
            }
        }
​
        return true;
    }
​
    private void do_union(int leader_x, int leader_x1, int[] parent) {
        if (leader_x1 != leader_x)
            parent[leader_x1] = leader_x;
    }
    
    // with path compression
    private int find_leader(int[] parent, int x) {
        if (parent[x]==x) return x;
        int t = find_leader(parent, parent[x]);
        parent[x]=t;
        return t;
    }
}
