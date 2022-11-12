/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    TreeNode* f(vector<int> &nums, int lo, int hi){
        if(lo > hi){
            return nullptr;
        }
        int mid = (lo + hi) >> 1;
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = f(nums, lo, mid-1);
        root->right = f(nums, mid + 1, hi);
        return root;
    }
    
    TreeNode* sortedArrayToBST(vector<int>& nums) {
       if(nums.empty()){
           return nullptr;
       }
        return f(nums, 0, nums.size() - 1);
    }
};
