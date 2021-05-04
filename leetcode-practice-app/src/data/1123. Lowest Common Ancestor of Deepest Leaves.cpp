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
    TreeNode* answer = nullptr; 
    int maxDepthNode = -1;
    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        TreeNode *tmp = root ;
        dfs(tmp,0);
        return answer ;
    }
    
    int dfs(TreeNode* root, int curDepth) {
        if(!root) {
            return curDepth;
        }
        int leftside = dfs(root->left, curDepth+1);
        int rightside = dfs(root->right, curDepth+1);
​
        if(leftside == rightside) {
            maxDepthNode = max(maxDepthNode, leftside);
            if(maxDepthNode == leftside) {
                answer = root;
            }
        }
​
        return max(leftside, rightside) ;
    }
​
};
