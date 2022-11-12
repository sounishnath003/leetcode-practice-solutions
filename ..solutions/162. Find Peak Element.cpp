class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        // int n = nums.size();
        // int lo = 0, hi = n-1;   
        // while(lo < hi) {
        //     int mid = lo+(hi-lo)/2;
        //     if(nums[mid] < nums[mid+1]){
        //         lo = mid + 1;
        //     }
        //     else {
        //         hi = mid;
        //     }
        // }
        // return lo;
        
        int maxelem = *max_element(nums.begin(), nums.end());
        return find(nums.begin(), nums.end(), maxelem) - nums.begin();
    }
};
