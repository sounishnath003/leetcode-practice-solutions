class Solution {
    private Map<String, Integer> dp = new HashMap<>();
    public int uniquePaths(int m, int n) {
        return find_paths(0,0,m,n);
    }
​
    private int find_paths(int i, int j, int m, int n) {
        if (i >= m || j >= n) return 0;
        if (dp.containsKey("" + i + '@' + j)) return dp.get(""+i+'@'+j);
        if (i==m-1 && j==n-1) {
            return 1;
        }
        int go_down=find_paths(i+1, j, m, n);
        int go_right=find_paths(i, j+1, m, n);
        dp.put(""+i+'@'+j, go_down+go_right);
        return go_down+go_right;
    }
}
