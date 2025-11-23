class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapp = {')': '(', '}': '{', ']': '['}

        for bracket in s:
            if bracket in mapp.values():
                stack.append(bracket)
            else:
                if not stack or stack[-1] != mapp[bracket]:
                    return False
                stack.pop()

        return not stack
