class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // map<int, int> cache;
        // for(auto &&x : nums){cache[x]++ ;}
        // for(auto &&p : cache) {
        //     if(p.second == 1){
        //         return p.first;
        //     }
        // }
        // return -1;
        
        int seen1 = 0,seen2 = 0;
        for(auto &&x : nums) {
            seen1 = ~seen2 & (seen1 ^ x);
            seen2 = ~seen1 & (seen2 ^ x);
        }
        return seen1;
    }
};
