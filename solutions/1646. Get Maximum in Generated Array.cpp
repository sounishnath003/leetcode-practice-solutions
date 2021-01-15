class Solution {
    vector<int> nums;
public:
    int getMaximumGenerated(int n) {
        if(n < 2) {
            return n;
        }
        nums.resize(n+1);
        nums[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            if(i&1) {
                nums[i] = nums[i/2]+nums[(i/2)+1];
            }
            else {
                nums[i] = nums[i/2];
            }
        }
     
        return *max_element(nums.begin(), nums.end());
    }
};
