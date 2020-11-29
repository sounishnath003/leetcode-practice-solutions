class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.empty()){
            return {-1,-1} ;
        }
        if(binary_search(nums.begin(), nums.end(), target) == false){
            return {-1,-1} ;
        }
        int lo = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        int hi = upper_bound(nums.begin(), nums.end(), target) - nums.begin();
        return {lo, hi-1} ;   
    }
};
