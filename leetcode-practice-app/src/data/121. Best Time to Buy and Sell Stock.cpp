class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0, minimal = 2e9+81;
        for(auto && x : prices){
            minimal = min(x, minimal);
            ans = max(ans, x - minimal);
        }
        return ans;
    }
};
