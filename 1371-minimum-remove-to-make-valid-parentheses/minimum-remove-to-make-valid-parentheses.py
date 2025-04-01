
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        # store indices of invalid parentheses in stack
        stack = [] # stores indices of opening brackets
        s_list = list(s)
        
        # First pass - mark invalid closing brackets
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            elif s[i] == ')':
                if stack: # if there's a matching opening bracket
                    stack.pop()
                else: # no matching opening bracket - invalid closing bracket
                    s_list[i] = ''
        
        # Second pass - remove unmatched opening brackets
        while stack:
            s_list[stack.pop()] = ''
            
        # Join remaining characters and return result
        return ''.join(s_list)