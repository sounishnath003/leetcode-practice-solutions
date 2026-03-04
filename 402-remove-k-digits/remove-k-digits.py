class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        
        for digit in num:
            # BUG 1 FIX: Use 'while' to pop all possible larger digits
            while stack and k > 0 and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)
        
        # BUG 2 FIX: If k is still > 0, remove from the end
        # (Already handled by your while loop at the bottom, but slicing is cleaner)
        final_stack = stack[:-k] if k > 0 else stack
        
        # BUG 3 FIX: Handle leading zeros and empty results using string join
        # Join the list and strip leading zeros, then handle the empty case
        res = "".join(final_stack).lstrip('0')
        
        return res if res else "0"