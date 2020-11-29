class Solution {
public:
    void rotate(vector<int>& nums, int k) { 
       if(k == 0 or nums.size() == 0)
           return;
        
         if(k>nums.size())
            k=k%nums.size();
        
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin()+k);
        reverse(nums.begin()+k, nums.end());
        return;
    }
};
