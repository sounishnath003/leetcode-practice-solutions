class Solution:
    def maxDepth(self, s: str) -> int:
        stack = []
        depth = 0
        for bracket in s:
            if bracket == '(':
                stack.append(bracket)
            elif bracket == ')':
                stack.pop()

            depth=max(depth, len(stack))

        return depth