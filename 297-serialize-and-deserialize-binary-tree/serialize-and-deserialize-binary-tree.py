# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        s = []
        q = deque([root])
        while q:
            node = q.popleft()
            if not node:
                s.append("#")
            else:
                s.append(str(node.val))
                q.append(node.left)
                q.append(node.right)
        return " ".join(s)       

    def deserialize(self, s):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        tokens = s.split()
        if not tokens or tokens[0] == "#":
            return None
        root = TreeNode(int(tokens[0]))
        q = deque([root])
        i = 1
        while q:
            node = q.popleft()
            if i < len(tokens):
                if tokens[i] != "#":
                    node.left = TreeNode(int(tokens[i]))
                    q.append(node.left)
                else:
                    node.left = None
                i += 1
            if i < len(tokens):
                if tokens[i] != "#":
                    node.right = TreeNode(int(tokens[i]))
                    q.append(node.right)
                else:
                    node.right = None
                i += 1
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))