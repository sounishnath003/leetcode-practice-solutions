class Solution {
    vector<bool> visited;
    public:
    bool canReach(vector<int>& nums, int start) {
        int n = nums.size();
        visited.resize(n+2);
        queue<int> q;
        
        q.push(start);
        
        while(!q.empty()) {
            start = q.front();
            q.pop();
            
            // go start - nums[start]
            {if(start - nums[start] >= 0 && !visited[start]) {
                if(start - nums[start] == 0 || nums[start] == 0) {
                    return true;
                }else if(start - nums[start] > 0) {
                    visited[start] = true;
                    q.push(start-nums[start]);
                }
            }else {continue;}}
            // go start + nums[start]
            {
                if(start + nums[start] < (int) nums.size()  && !visited[start]) {
                if(start + nums[start] == 0 || nums[start] == 0 ) {
                    return true;
                }else if (start - nums[start] > 0) {
                    visited[start] = true;
                    q.push(start+nums[start]);
                }
            }else {continue;}
            }
        }
        return false;
    
        // bool ans = dfs(nums, start);
        // return ans;
    }
​
    bool dfs(vector<int> &nums, int start) {
        if(start < 0 || start >= (int) nums.size() || visited[start]) {
            return false;
        }
        visited[start] = true;
        if(nums[start] == 0){
            return true;
        }
        bool ans1 = dfs(nums, start + nums[start]);
        bool ans2 = dfs(nums, start - nums[start]);
        return ans1 || ans2;
    }
};
