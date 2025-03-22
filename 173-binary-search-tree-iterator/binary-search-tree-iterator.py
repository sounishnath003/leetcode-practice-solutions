class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack=[]
        self.add_all_left(root)

    def add_all_left(self, root):
        while root:
            self.stack.append(root)
            root=root.left

    def next(self) -> int:
        if self.hasNext():
            node=self.stack.pop()
            # does it has right
            if node.right is not None:
                self.add_all_left(node.right)

            return node.val
        
        return -1

    def hasNext(self) -> bool:
        return len(self.stack)>0
        