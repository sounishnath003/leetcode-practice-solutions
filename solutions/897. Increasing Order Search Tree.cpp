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
    vector<TreeNode*> nodes;
public:
    TreeNode* increasingBST(TreeNode* root) {
        if(root == NULL) {
            return nullptr;
        }
        
        inorder(root);
        
        for(int i = 0; i < (int) nodes.size()-1; i++ ) {
            nodes[i]->left = nullptr;
            nodes[i]->right = nodes[i+1];
        }
        nodes.back()->left = nullptr;
        nodes.back()->right = nullptr;
        
        return nodes[0];
    }
    
    void inorder(TreeNode* root) {
        if(!root) {
            return ;
        }
        inorder(root->left);
        nodes.push_back(root);
        inorder(root->right);
    }
};
