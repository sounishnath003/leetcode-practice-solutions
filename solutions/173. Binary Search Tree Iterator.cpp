 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class BSTIterator {
    int index = 0;
    vector<int> nodes;
    stack <TreeNode*> cache;
public:
    BSTIterator(TreeNode* root) {
        // inorder(root) ;
        dfs(root) ;
    }
    
    void dfs(TreeNode* root) {
       while(root) {
           cache.push(root) ;
           root = root -> left ;
       }
    }
    
    int next() {
        // return nodes[index++] ;
        TreeNode* top = cache.top();
        cache.pop(); // delete from stack
        dfs(top-> right) ;
        return top -> val ;
    }
    
    bool hasNext() {
        // return index < (int) nodes.size( ) ;
        
        return !cache.empty();
    }
};
​
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
