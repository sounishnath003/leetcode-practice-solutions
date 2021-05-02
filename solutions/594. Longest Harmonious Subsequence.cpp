class Solution {
public:
    int findLHS(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int left = 0, right = 1, ans=0;
        while(right < (int) nums.size()) {
            int diff = nums[right]-nums[left];
            if(diff == 1) {
                ans = max(ans, right-left+1);
            }
            // 2 2 3
            if(diff <= 1) {right++;}else{left++;}
        }
        return ans;
    }
};
