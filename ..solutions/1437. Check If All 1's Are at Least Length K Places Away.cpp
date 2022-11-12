class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        if(nums.empty()) { return false; }
        int oneIndex = -1; bool assume=true;
        for(int i = 0; i < nums.size(); i++) {
            int one = nums[i];
            if(one==1){
                if(oneIndex==-1)
                    oneIndex=i;
                else {
                    int dist = i - oneIndex - 1 ;
                    if(dist < k) {
                        assume = false;
                        break;
                    }
                    oneIndex=i;
                }
            }
        }
        return assume;
    }
};
