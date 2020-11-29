class Solution {
public:
    bool canPartition(vector<int>& nums) {
         int sum = (int) accumulate(nums.begin(), nums.end(),0);
        if(sum&1){
            return false;
        }else {
            sum = (int) sum/2;
            vector<bool> dp(sum+1);
            dp[0] = true;
            for(auto &&x : nums) {
                // if sumX is present that means sumX-(something) also present
                for(int i = sum; i >= x; i--){
                    dp[i] = dp[i] || dp[i-x] ;
                }
            }
            // debug() << imie(dp);
            return dp.back();
        }   
    }
};
