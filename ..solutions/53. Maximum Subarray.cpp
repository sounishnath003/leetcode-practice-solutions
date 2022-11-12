using arr = vector<int>;
const int inf = 2e9+18;
int maxx = -1 * inf;
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size() ;
        arr dp(n);
        dp[0] = nums[0];
        maxx = dp[0];
        for(int i = 1; i < n; i++){
            if(dp[i-1] + nums[i] > nums[i]){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            maxx = max(dp[i],maxx);
        }
        return maxx;
    }
};
