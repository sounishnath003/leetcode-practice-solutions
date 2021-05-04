class Solution {
public:
    bool canJump(vector<int>& nums) {
        int len = nums.size();
        int maxjp = 0;
        for(int i = 0; i <= maxjp; i++){
            maxjp = max(maxjp, i+nums[i]);
            if(maxjp >= len-1){
                return true;
            }
        }
        return false;
    }
};
