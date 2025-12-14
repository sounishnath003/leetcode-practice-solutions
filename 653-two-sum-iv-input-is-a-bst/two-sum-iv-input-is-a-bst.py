class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        def two_sum_bst(root, k:int) -> bool:
            class BSTIterator:
                def __init__(self, root, reverse:bool=False) -> None:
                    self.stack = []
                    self.reverse=reverse
                    self.add_all(root)

                def add_all(self, root):
                    while root:
                        self.stack.append(root)
                        if self.reverse:
                            root = root.right
                        else:
                            root = root.left

                def has_next(self) -> bool:
                    return self.stack

                def next(self):
                    if self.has_next():
                        node = self.stack.pop()
                        if self.reverse:
                            if node.left:
                                self.add_all(node.left)
                        else:
                            if node.right:
                                self.add_all(node.right)
                        return node.val

                    return -1

            # perform this
            if not root: return False

            left = BSTIterator(root, reverse=False)
            right = BSTIterator(root, reverse=True)

            a = left.next()
            b = right.next()

            while a < b:
                if (a + b == k): return True
                elif (a + b > k): b = right.next()
                else: a = left.next()

            return False 

        return two_sum_bst(root, k)