from collections import defaultdict
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        current_num = None
        current_freq = 0
        max_freq = 0
        result = defaultdict(list)
        
        def traverse_fn(root: TreeNode):
            nonlocal current_num, current_freq, max_freq, result
            if not root:
                return 
            
            traverse_fn(root.left)
            
            if current_num == root.val:
                current_freq += 1
            else:
                current_num = root.val
                current_freq = 1 
                
            if current_freq > max_freq:
                result = []
                max_freq = current_freq
                
            if current_freq == max_freq:
                result.append(root.val)

            traverse_fn(root.right)

        traverse_fn(root)

        return result