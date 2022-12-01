class Solution:
    def calculate(self, s: str) -> int:
        sums = 0
        i = 0
        sign = 1
        stack = []
        length = len(s)
        while i<length:
            char = s[i]
            if char.isdigit():
                val = 0
                while i<length and s[i].isdigit():
                    val = val*10 + int(s[i])
                    i+=1
                i-=1
                sums+=val*sign
                sign = 1
            elif char == '(':
                stack.append(sums)
                stack.append(sign)
                sums,sign = 0,1
            elif char == ')':
                sums*=stack.pop()
                sums+=stack.pop()
            elif char =='-':
                sign*=-1
            i+=1
            
        return sums
