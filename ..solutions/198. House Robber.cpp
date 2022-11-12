class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty() or nums.size() == 0){
            return 0;
        }
        if(nums.size() == 1){
            return nums[0];
        }
        if(nums.size() == 0){
            return max(nums[0], nums[1]);
        }
        int n = nums.size();
        vector<int> dp(n);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
};
