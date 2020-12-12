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
class BSTIterator {
    int index = 0;
public:
    vector<int> nodes;
    BSTIterator(TreeNode* root) {
        inorder(root) ;
    }
    
    void inorder(TreeNode* root) {
        if(!root) {
            return ;
        }
        inorder(root-> left ) ;
        nodes.push_back(root->val) ;
        inorder(root ->  right ) ;
    }
    
    int next() {
        return nodes[index++] ;
    }
    
    bool hasNext() {
        return index < (int) nodes.size( ) ;
    }
};
​
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
