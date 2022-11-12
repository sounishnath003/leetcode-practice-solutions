class Solution {
public:
    
    void dfs(vector<vector<int>> &subsets, vector<int> &nums, int index, vector<int> current){
​
        subsets.push_back(current);
        for(int i = index; i < nums.size(); i++){
            current.push_back(nums[i]);
            dfs(subsets, nums, i+1, current);
            current.pop_back();
        }
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> subsets;
        dfs(subsets, nums, 0, vector<int>());
        return subsets;
    }
};
