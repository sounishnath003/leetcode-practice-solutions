class Solution {
public:
    void dfs( vector<vector<int>>& subsets,
    int index, int n, int k, vector<int> currrent) {
        if((int) currrent.size() == k) {
            subsets.push_back(currrent);
            return;
        }
        for(int i = index; i < n+1; i++) {
            currrent.push_back(i);
            dfs(subsets, i+1, n, k, currrent);
            currrent.pop_back();
        }
    }
    
    vector<vector<int>> combine(int n, int k) {
      vector<vector<int>> subsets;
      dfs(subsets, 1, n, k, vector<int>());
      return subsets;
    }
};
