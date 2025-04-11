
MAX = float('inf')
MIN = -MAX

class Result:
    def __init__(self, minv, maxv, isBST, total):
        self.minv=minv
        self.maxv=maxv
        self.isBST=isBST
        self.total=total


class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        max_sum=0

        """write a recursion to person the check of isbst and keep updating the sum"""    
        def f(root) -> Result:
            global MIN, MAX
            nonlocal max_sum

            # if root is null is BST but return a unknown value
            if not root:
                return Result(MAX, MIN, True, 0)
            
            # keep faith and perform the left and right tree checks
            left=f(root.left)
            right=f(root.right)

            # check if this tree is BST and everything is proper
            if left.isBST and right.isBST and left.maxv < root.val < right.minv:
                # calculate the my sum
                mysum = left.total + root.val + right.total
                # update the my sum if bigger
                max_sum=max(max_sum, mysum)
                # return the updated value
                return Result(min(left.minv, root.val), max(root.val, right.maxv), True, mysum)
            
            # if not a right tree return bad val
            return Result(0,0,False,0)
    
        # call the func 
        f(root)
        
        return max_sum
    
    def maxSumBST2(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def f(root): # returns [min_val, max_val, is_bst, sum_of_bst]
            if not root:
                return [MAX, MIN, True, 0]

            left_rec = f(root.left)
            right_rec = f(root.right)

            is_bst = False
            current_sum = 0

            if left_rec[2] and right_rec[2] and root.val > left_rec[1] and root.val < right_rec[0]:
                is_bst = True
                current_sum = root.val + left_rec[3] + right_rec[3]
                self.ans = max(self.ans, current_sum)

            min_val = min(root.val, left_rec[0])
            max_val = max(root.val, right_rec[1])

            return [min_val, max_val, is_bst, current_sum if is_bst else 0]

        f(root)
        return self.ans