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
var levelOrder = function (root) {
  let result = [];
​
   function dfs (root, level) {
        if (!root) return;
​
        dfs(root.left, level + 1);
​
        if (result[level]) {
          result[level].push(root.val);
        } else {
          result[level] = [root.val];
        }
​
        dfs(root.right, level + 1);
    };
      dfs(root, 0);
      return result;
};
​
