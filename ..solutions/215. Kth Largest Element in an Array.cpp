class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>> q(nums.begin(), nums.end());
        while(--k) {
            q.pop();
        }
        return q.top();
    }
};
