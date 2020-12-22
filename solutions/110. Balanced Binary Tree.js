/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
    if(!root) {
        return true ;
    }
    
    function dfs(root) {
        if (!root) {
            return 0 ;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
    
    if(Math.abs(dfs(root.left) - dfs(root.right)) > 1) {
        return false;
    }
    
    return isBalanced(root.left) && isBalanced(root.right);
};
