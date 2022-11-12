class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        /*
            * iterative approch exists, but need O(N) extra space
            * n = size of vector<int>nums.
        */
        sort(nums.begin(), nums.end());
        vector<vector<int>> subsets;
        dfs(nums, subsets, 0, vector<int>());
        return subsets;
    }
    
    void dfs(vector<int> &nums, vector<vector<int>> &subsets, int index, vector<int> current){
        subsets.push_back(current);
        for(int i = index; i < (int) nums.size(); i++){
            if(index < i && nums[i-1] == nums[i]){
                continue;
            }
            current.push_back(nums[i]);
            dfs(nums, subsets, i+1, current);
            current.pop_back();
        }
    }
};
