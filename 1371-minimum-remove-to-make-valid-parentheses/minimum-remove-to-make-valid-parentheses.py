
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        # store indices of invalid parentheses in stack
        stack = [] # stores indices of opening brackets
        s_list = list(s)
        # First pass - mark invalid closing brackets
        for i in range(len(s)):
            if s[i] == '(':
                # Store index of opening bracket
                stack.append(i)
            elif s[i] == ')':
                # For closing bracket, check if we have matching opening bracket
                if stack and s[stack[-1]] == '(':
                    stack.pop()
                else:
                    # No matching opening bracket, mark as invalid
                    s_list[i] = ''
        # Second pass - remove unmatched opening brackets
        while stack:
            s_list[stack.pop()] = ''
            
        # Join remaining characters and return result
        return ''.join(s_list)