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
    int cache[10];
    int answer = 0;
public:
    int pseudoPalindromicPaths (TreeNode* root) {
        dfs (root);
        return answer ;
    }
    
    void dfs(TreeNode* root) {
        if (root==nullptr) {
            return ;
        }
        cache[root->val]++;
        if (!root->left && !root->right) {
            if (isPaindome()) {
                answer++;
            }
        }else {
            dfs(root->left);
            dfs(root->right);
        }
        cache[root->val]-- ;
    }
​
    bool isPaindome() {
        int oddparity = 0;
        for (int i = 1 ; i <= 9; i++) {
            int x = cache[i];
            if(x&1){
                oddparity++;
            }
        }
        return oddparity < 2 ;
    }
​
​
};
