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
 * @return {number[][]}
 */
var zigzagLevelOrder = function(root) {
     let result = [];
​
    const loot = (root, level) => {
        if(!root) {return ; }
        
        if(result[level]){
            result[level].push(root.val);
        } else {
            result[level] = [root.val] ;
        }
​
        loot(root.left, level+1);
        loot(root.right, level+1);
    } 
    loot(root, 0);
​
    results = result.map((arr, index) => {
        (index%2 === 1) ? arr.reverse() : arr;
    });
​
    return result; 
};
