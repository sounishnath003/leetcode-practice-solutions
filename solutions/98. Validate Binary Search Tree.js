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
var isValidBST = function(root) {
    function validateBST (root, start, end) {
        if(!root) {
            return true ;
        }
​
        if(start < root.val && root.val < end) {
            return true && validateBST(root.left, start, root.val) && validateBST(root.right, root.val, end) ;
        }
        return false ;
    }
​
    return validateBST(root, -Infinity, Infinity)
};
