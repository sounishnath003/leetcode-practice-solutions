class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]

        # iterate on all brackets and add into stack
        # if stack top elem != open.position of the brackets then return False
        for bracket in s:
            if len(stack) == 0 and bracket not in [ '(', '{', '[' ]:
                return False
            elif bracket in [ '(', '{', '[' ]:
                stack.append(bracket)
            else:
                if len(stack) == 0:
                    return False
                if (
                    bracket == ')' and stack[-1] != '('
                    or bracket == '}' and stack[-1] != '{'
                    or bracket == ']' and stack[-1] != '['
                ):
                    return False
                else:
                    stack.pop()

        return len(stack) == 0