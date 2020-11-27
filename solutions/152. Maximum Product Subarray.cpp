#define fo(i, k, n) for(int i = k; i < n; i++)
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        int ans = nums[0], rmx = nums[0], rmn = nums[0];
        fo(i, 1, n){
            int cmax = rmx;
            rmx = max({rmx*nums[i], nums[i], rmn*nums[i]});
            rmn = min({cmax*nums[i], rmn*nums[i], nums[i]});
            ans = max(rmx,ans);
        }
        return ans ;
    }
};
