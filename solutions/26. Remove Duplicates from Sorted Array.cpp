class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // auto itr = unique(nums.begin(), nums.end());
        // nums.resize(distance(nums.begin(), itr));
        // return nums.size();
        
        int n = nums.size();
        if (n < 2) return n;
        
        int tmp = nums[0];
        int ret = 1;
        for (int i = 1; i < n; i++) {
            if (tmp != nums[i]) {
                nums[ret] = nums[i];
                ret++;
                
                tmp = nums[i];
            }
        }
        
        return ret;
    }
};
