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
​
/*
    Solution 1 - O(N*N) looks
    ---------------------------
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
*/
​
var isBalanced = function(root) {
    if(!root) {
        return true ;
    }
    
    function dfs(root) {
        if (!root) {
            return 0 ;
        }
        
        leftHeight = dfs(root.left);
        rightHeight = dfs(root.right);
        balanceFactor = Math.abs (leftHeight - rightHeight);
        
        if (balanceFactor > 1 || leftHeight == -1 || rightHeight == -1) {return -1;}
        
        return 1 + Math.max(leftHeight, rightHeight) ;
    }
    
   return dfs(root) != -1;
};
