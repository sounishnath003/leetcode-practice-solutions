class Solution {
    const int inf = 2e9+88;
public:
    int minOperations(vector<int>& nums, int x) {
       int sum = -x;
       for (int z : nums)
            sum += z;
       if(sum==0){
           return (int) nums.size();
       }
        if (sum < 0)
            return -1;
        int ans = -1, pref = 0, lo=0;
        for (int i = 0; i < (int) nums.size(); i++) {
            pref+=nums[i];
            while (pref > sum) {
                pref = pref - nums[lo++];
            }
            if (pref == sum) {
                // got ans
                ans = max(ans, i - lo + 1);
            }
        }
        return ans==-1 ? -1 : (int) nums.size() - ans;
    }
};
