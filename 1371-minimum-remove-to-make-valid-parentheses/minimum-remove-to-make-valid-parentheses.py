class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        s_list = list(s)
        stack = []

        for i, char in enumerate(s_list):
            if char == '(': stack.append(i)
            elif char == ')':
                if not stack or s_list[stack[-1]] != '(':
                    s_list[i] = ''
                else:
                    stack.pop()

        while stack: s_list[stack.pop()] = ''

        return "".join(s_list)