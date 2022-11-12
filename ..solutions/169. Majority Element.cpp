class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> cache ;
        for(auto &&x : nums ){
            cache[x]++;
        }
        int ans= 0;
        for(int x : nums){
            if(ans <= cache[x] && (n / 2) < cache[x] ){
                ans = x;
            }
        }
        return ans;
    }
};
